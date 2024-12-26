package com.simonhochrein.intellijca65.language.ca65

import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.*
import com.intellij.psi.impl.source.resolve.reference.impl.providers.FileReference
import com.intellij.psi.impl.source.resolve.reference.impl.providers.FileReferenceSet
import com.intellij.psi.search.FilenameIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.ProcessingContext
import com.simonhochrein.intellijca65.language.ca65.psi.CA65Include
import com.simonhochrein.intellijca65.language.ca65.psi.CA65StringLiteral
import java.util.*

class CA65ReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            psiElement(CA65StringLiteral::class.java).inside(CA65Include::class.java),
            CA65ReferenceProvider(),
            PsiReferenceRegistrar.HIGHER_PRIORITY
        )
    }
}

class CA65ReferenceProvider : PsiReferenceProvider() {
    override fun getReferencesByElement(element: PsiElement, p1: ProcessingContext): Array<FileReference> {
        val results =  CA65ReferenceSet(element).allReferences

        return results
    }
}

class CA65ReferenceSet(myElement: PsiElement) : FileReferenceSet(myElement.text.substring(1, myElement.textLength - 1), myElement, 1, null, true, true, arrayOf(CA65FileType.INSTANCE)) {
    override fun computeDefaultContexts(): MutableCollection<PsiFileSystemItem> {
        val containingFile = element.containingFile

        return Collections.singletonList(containingFile.parent)
    }
    override fun createFileReference(range: TextRange?, index: Int, text: String?): FileReference {
        return CA65Reference(this, range, index, text)
    }

    private inner class CA65Reference(referenceSet: CA65ReferenceSet, range: TextRange?, index: Int, text: String?) :
        FileReference(referenceSet, range, index, text) {
        override fun innerResolveInContext(
            text: String,
            context: PsiFileSystemItem,
            result: MutableCollection<in ResolveResult>,
            caseSensitive: Boolean
        ) {
            ProgressManager.checkCanceled()
            super.innerResolveInContext(text, context, result, caseSensitive)

            if (containingFile !is CA65File) return

            val matchingFiles = FilenameIndex.getVirtualFilesByName(text, GlobalSearchScope.projectScope(context.project)).toTypedArray()

            val matchedFile = element.manager.findFile(matchingFiles[0]) ?: return

            result.add(PsiElementResolveResult(matchedFile))
        }
    }
}

private fun getRange(range: TextRange?) = range?.let { TextRange(it.startOffset+1, it.endOffset-1) }
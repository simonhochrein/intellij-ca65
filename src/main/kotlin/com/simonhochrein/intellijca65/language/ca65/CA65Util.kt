package com.simonhochrein.intellijca65.language.ca65

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import com.simonhochrein.intellijca65.language.ca65.psi.CA65Include
import com.simonhochrein.intellijca65.language.ca65.psi.CA65Label
import com.simonhochrein.intellijca65.language.ca65.psi.CA65Proc
import com.simonhochrein.intellijca65.language.ca65.psi.CA65Section
import com.simonhochrein.intellijca65.language.ca65.psi.CA65Types

object CA65Util {
    fun findImports(project: Project): List<CA65Include> {
        val result = arrayListOf<CA65Include>()
        val virtualFiles = FileTypeIndex.getFiles(CA65FileType.INSTANCE, GlobalSearchScope.allScope(project))

        for (virtualFile in virtualFiles) {
            val ca65File = PsiManager.getInstance(project).findFile(virtualFile) ?: continue

            PsiTreeUtil.getChildrenOfType(ca65File, CA65Include::class.java)?.forEach {
                result.add(it)
            }
        }

        return result
    }

    fun findLabels(project: Project, name: String): List<PsiElement> {
        val result = arrayListOf<PsiElement>()
        val virtualFiles = FileTypeIndex.getFiles(CA65FileType.INSTANCE, GlobalSearchScope.allScope(project))

        for (virtualFile in virtualFiles) {
            val ca65File = PsiManager.getInstance(project).findFile(virtualFile) ?: continue

            result.addAll(
            PsiTreeUtil.findChildrenOfType(ca65File, CA65Section::class.java).filter { it.label.text.startsWith(name) }
                .mapNotNull { it.label.node.findChildByType(CA65Types.IDENTIFIER)?.psi }
            )

        }

        return result
    }

    fun findProcs(project: Project, name: String): List<PsiElement> {
        val result = arrayListOf<PsiElement>()
        val virtualFiles = FileTypeIndex.getFiles(CA65FileType.INSTANCE, GlobalSearchScope.allScope(project))

        for (virtualFile in virtualFiles) {
            val ca65File = PsiManager.getInstance(project).findFile(virtualFile) ?: continue

            result.addAll(
                PsiTreeUtil.findChildrenOfType(ca65File, CA65Proc::class.java).filter { it.name == name }
                    .mapNotNull { it.node.findChildByType(CA65Types.IDENTIFIER)?.psi }
            )
        }

        return result
    }
}
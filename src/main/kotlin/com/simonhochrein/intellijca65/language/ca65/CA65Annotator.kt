package com.simonhochrein.intellijca65.language.ca65

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.simonhochrein.intellijca65.language.ca65.psi.CA65Label

class CA65Annotator: Annotator, DumbAware {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is CA65Label) {
            mark(element, holder, CA65SyntaxHighlighter.LABEL)
        }
    }

}

private fun mark(element: PsiElement, holder: AnnotationHolder, key: TextAttributesKey) {
    holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(element).textAttributes(key).create()
}
package com.simonhochrein.intellijca65.language.ca65.psi.impl

import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.paths.PathReference
import com.intellij.openapi.paths.PathReferenceManager
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceService
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
import com.simonhochrein.intellijca65.language.ca65.CA65FileType
import com.simonhochrein.intellijca65.language.ca65.psi.*

fun getKey(element: CA65Section) = element.label.text ?: ""

fun getKey(element:CA65NamespacedIdentifier): String = element.node.text

fun getValue(element: CA65Section) = ""

fun getName(element: CA65NamespacedIdentifier): String = element.node.text

fun getName(element: CA65Section): String = element.label.text ?: ""
fun getName(element: CA65Proc): String = element.node.findChildByType(CA65Types.IDENTIFIER)?.text ?: ""

fun setName(element: CA65Section, name: String): CA65Section {
    element.node.findChildByType(CA65Types.LABEL)?.let {
        val label = createLabel(element.project, name)
        val newLabelNode = label.firstChild.node
        element.node.replaceChild(it, newLabelNode)
    }
    return element
}

fun setName(element: CA65NamespacedIdentifier, name: String): CA65NamespacedIdentifier {
    return element
}

fun setName(element: CA65Proc, name: String): CA65Proc {
    return element
}

fun getNameIdentifier(element: CA65Section) = element.node.findChildByType(CA65Types.LABEL)?.psi

fun getNameIdentifier(element: CA65NamespacedIdentifier): PsiElement = element

fun getNameIdentifier(element: CA65Proc) = element.node.findChildByType(CA65Types.IDENTIFIER)?.psi

fun getPresentation(element: CA65Section) = object: ItemPresentation {
    override fun getPresentableText() = element.key
    override fun getLocationString() = element.containingFile.name
    override fun getIcon(p0: Boolean) = element.getIcon(0)
}

fun getPresentation(element: CA65Proc) = object: ItemPresentation {
    override fun getPresentableText() = element.name
    override fun getLocationString() = element.containingFile.name
    override fun getIcon(p0: Boolean) = element.getIcon(0)
}

fun getReferences(element: CA65NamespacedIdentifier): Array<PsiReference> {
    return ReferenceProvidersRegistry.getReferencesFromProviders(element, PsiReferenceService.Hints.HIGHLIGHTED_REFERENCES)
}
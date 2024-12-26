package com.simonhochrein.intellijca65.language.ca65.psi.impl

import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.paths.PathReference
import com.intellij.openapi.paths.PathReferenceManager
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiReference
import com.simonhochrein.intellijca65.language.ca65.CA65FileType
import com.simonhochrein.intellijca65.language.ca65.psi.*

fun getKey(element: CA65Section) = element.node.findChildByType(CA65Types.LABEL)?.text

fun getValue(element: CA65Section) = ""

fun setName(element: CA65Section, name: String): CA65Section {
    element.node.findChildByType(CA65Types.LABEL)?.let {
        val label = createLabel(element.project, name)
        val newLabelNode = label.firstChild.node
        element.node.replaceChild(it, newLabelNode)
    }
    return element
}

fun getNameIdentifier(element: CA65Section) = element.node.findChildByType(CA65Types.LABEL)?.psi

fun getReference(element: CA65Include): Array<PsiReference> {
    val el = element.node.findChildByType(CA65Types.STRING)
    return PathReferenceManager.getInstance().createReferences(element, false, false, true, arrayOf(CA65FileType.INSTANCE))
}

fun getPresentation(element: CA65Section) = object: ItemPresentation {
    override fun getPresentableText() = element.key
    override fun getLocationString() = element.containingFile.name
    override fun getIcon(p0: Boolean) = element.getIcon(0)
}
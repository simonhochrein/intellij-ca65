package com.simonhochrein.intellijca65.language.ca65.psi.impl

import com.intellij.navigation.ItemPresentation
import com.simonhochrein.intellijca65.language.ca65.psi.CA65Section
import com.simonhochrein.intellijca65.language.ca65.psi.CA65Types
import com.simonhochrein.intellijca65.language.ca65.psi.createLabel
import javax.swing.Icon

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

fun getPresentation(element: CA65Section) = object: ItemPresentation {
    override fun getPresentableText() = element.key
    override fun getLocationString() = element.containingFile.name
    override fun getIcon(p0: Boolean) = element.getIcon(0)
}
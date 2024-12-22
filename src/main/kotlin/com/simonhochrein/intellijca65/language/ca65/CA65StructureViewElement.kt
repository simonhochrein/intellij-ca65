package com.simonhochrein.intellijca65.language.ca65

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.simonhochrein.intellijca65.language.ca65.psi.CA65Section
import com.simonhochrein.intellijca65.language.ca65.psi.impl.CA65SectionImpl
import javax.swing.Icon

class CA65StructureViewElement(element: NavigatablePsiElement): StructureViewTreeElement, ItemPresentation {
    private val myElement = element

    override fun getPresentation() = myElement.presentation ?: PresentationData()

    override fun getChildren(): Array<TreeElement> {
        if (myElement is CA65File) {
            val sections = PsiTreeUtil.getChildrenOfType(myElement, CA65Section::class.java) ?: return emptyArray()
            val treeElements = arrayListOf<CA65StructureViewElement>()

            for (section in sections) {
                treeElements.add(CA65StructureViewElement(section as CA65SectionImpl))
            }
            return treeElements.toTypedArray()
        }
        return emptyArray()
    }

    override fun getValue() = myElement

    override fun canNavigate() = myElement.canNavigate()
    override fun canNavigateToSource() = myElement.canNavigateToSource()
    override fun navigate(requestFocus: Boolean) = myElement.navigate(requestFocus)

    override fun getPresentableText(): String? {
        if (myElement is CA65Section) {
            return myElement.label.text
        }
        if (myElement is CA65File) {
            return myElement.name
        }

        return null
    }

    override fun getIcon(p0: Boolean) = AllIcons.Nodes.Lambda
}

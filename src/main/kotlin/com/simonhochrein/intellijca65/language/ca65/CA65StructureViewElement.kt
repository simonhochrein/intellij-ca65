package com.simonhochrein.intellijca65.language.ca65

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.simonhochrein.intellijca65.language.ca65.psi.CA65Proc
import com.simonhochrein.intellijca65.language.ca65.psi.CA65Section
import com.simonhochrein.intellijca65.language.ca65.psi.impl.CA65ProcImpl
import com.simonhochrein.intellijca65.language.ca65.psi.impl.CA65SectionImpl
import javax.swing.Icon

class CA65StructureViewElement(element: NavigatablePsiElement): StructureViewTreeElement, ItemPresentation {
    private val myElement = element

    override fun getPresentation() = myElement.presentation ?: PresentationData()

    override fun getChildren(): Array<TreeElement> {
        if (myElement is CA65File) {
            val results = arrayListOf<TreeElement>()
            results.addAll(PsiTreeUtil.getChildrenOfType(myElement, CA65Section::class.java)?.map { CA65StructureViewElement(it as CA65SectionImpl) } ?: emptyList())
            results.addAll(PsiTreeUtil.getChildrenOfType(myElement, CA65Proc::class.java)?.map { CA65StructureViewElement(it as CA65ProcImpl) } ?: emptyList())

            return results.toTypedArray()
        }
        if(myElement is CA65Proc) {
            val results = arrayListOf<TreeElement>()
            results.addAll(PsiTreeUtil.getChildrenOfType(myElement, CA65Section::class.java)?.map { CA65StructureViewElement(it as CA65SectionImpl) } ?: emptyList())
            return results.toTypedArray()
        }
        return emptyArray()
    }

    override fun getValue() = myElement

    override fun canNavigate() = myElement.canNavigate()
    override fun canNavigateToSource() = myElement.canNavigateToSource()
    override fun navigate(requestFocus: Boolean) = myElement.navigate(requestFocus)

    override fun getPresentableText() = when (myElement) {
        is CA65Section -> myElement.label.text
        is CA65File -> myElement.name
        is CA65Proc -> (myElement as CA65Proc).name
        else -> null
    }

    override fun getIcon(p0: Boolean) = AllIcons.Nodes.Lambda
}

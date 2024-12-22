package com.simonhochrein.intellijca65.language.ca65

import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import com.simonhochrein.intellijca65.language.ca65.psi.CA65Section

class CA65StructureViewModel(editor: Editor?, psiFile: PsiFile) :
    StructureViewModelBase(psiFile, editor, CA65StructureViewElement(psiFile)), StructureViewModel.ElementInfoProvider {
    init {
        withSuitableClasses(CA65File::class.java, CA65Section::class.java)
    }

    override fun isAlwaysShowsPlus(p0: StructureViewTreeElement?) = false

    override fun isAlwaysLeaf(element: StructureViewTreeElement?) = false
}

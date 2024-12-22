package com.simonhochrein.intellijca65.language.ca65

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider

class CA65File(viewProvider: FileViewProvider): PsiFileBase(viewProvider, CA65Language.INSTANCE) {
    override fun getFileType() = CA65FileType.INSTANCE

    override fun toString() = "CA65 File"
}
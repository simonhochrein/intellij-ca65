package com.simonhochrein.intellijca65.language.ca65

import com.intellij.openapi.fileTypes.LanguageFileType

class CA65FileType : LanguageFileType(CA65Language.INSTANCE) {
    companion object {
        val INSTANCE = CA65FileType()
    }

    override fun getName() = "CA65 File"
    override fun getDescription() = "CC65 assembly file"
    override fun getDefaultExtension() = "s"
    override fun getIcon() = CA65Icons.FILE
}
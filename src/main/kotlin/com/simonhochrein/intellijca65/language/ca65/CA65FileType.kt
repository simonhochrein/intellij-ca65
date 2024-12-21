package com.simonhochrein.intellijca65.language.ca65

import com.intellij.openapi.fileTypes.LanguageFileType

object CA65FileType: LanguageFileType(CA65Language.INSTANCE) {
    override fun getName() = "CA65 File"

    override fun getDescription() = "CC65 assembly file"

    override fun getDefaultExtension() = "s"

    override fun getIcon() = CA65Icons.FILE
}
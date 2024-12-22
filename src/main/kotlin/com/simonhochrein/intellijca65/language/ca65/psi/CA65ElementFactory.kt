package com.simonhochrein.intellijca65.language.ca65.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory
import com.simonhochrein.intellijca65.language.ca65.CA65File
import com.simonhochrein.intellijca65.language.ca65.CA65FileType

fun createLabel(project: Project, name: String): CA65Label {
    val file = createFile(project, name)
    return file.firstChild as CA65Label
}

fun createFile(project: Project, name: String): CA65File {
    return PsiFileFactory.getInstance(project).createFileFromText("test:", CA65FileType.INSTANCE, name) as CA65File
}

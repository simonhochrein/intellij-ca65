package com.simonhochrein.intellijca65.editor

import com.intellij.codeInsight.editorActions.TypedHandlerDelegate
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.EditorCoreUtil
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.simonhochrein.intellijca65.language.ca65.CA65File

class CA65TypedHandler : TypedHandlerDelegate() {
    override fun beforeCharTyped(c: Char, project: Project, editor: Editor, file: PsiFile, fileType: FileType): Result {
        if (file !is CA65File) return Result.CONTINUE

        if(c == ':') {
            val document = editor.document
            val offset = editor.caretModel.offset

            EditorCoreUtil.indentLine(project, editor, document.getLineNumber(offset), -4, false)
        }

        return Result.CONTINUE
    }
}

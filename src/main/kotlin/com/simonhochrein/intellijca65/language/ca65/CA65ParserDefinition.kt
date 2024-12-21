package com.simonhochrein.intellijca65.language.ca65

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import com.simonhochrein.intellijca65.language.ca65.psi.CA65Types

class CA65ParserDefinition: ParserDefinition {
    companion object {
        val FILE = IFileElementType(CA65Language.INSTANCE)
    }

    override fun createLexer(project: Project) = CA65LexerAdapter()

    override fun getCommentTokens() = CA65TokenSets.COMMENTS

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun createParser(p0: Project?) = CA65Parser()

    override fun getFileNodeType() = FILE

    override fun createFile(viewProvider: FileViewProvider) = CA65File(viewProvider)

    override fun createElement(node: ASTNode): PsiElement = CA65Types.Factory.createElement(node)
}
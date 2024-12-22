package com.simonhochrein.intellijca65.language.ca65

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.simonhochrein.intellijca65.language.ca65.psi.CA65Types

class CA65SyntaxHighlighter: SyntaxHighlighterBase() {
    companion object {
        val COMMENT = createTextAttributesKey("CA65_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val BAD_CHARACTER = createTextAttributesKey("CA65_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
        val STRING = createTextAttributesKey("CA65_STRING", DefaultLanguageHighlighterColors.STRING)
        val MACRO = createTextAttributesKey("CA65_MACRO", DefaultLanguageHighlighterColors.METADATA)
        val LABEL = createTextAttributesKey("CA65_LABEL", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
        val NUMBER = createTextAttributesKey("CA65_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        val OPCODE = createTextAttributesKey("CA65_OPCODE", DefaultLanguageHighlighterColors.KEYWORD)

        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val EMPTY_KEYS = arrayOf<TextAttributesKey>()
        private val STRING_KEYS = arrayOf(STRING)
        private val MACRO_KEYS = arrayOf(MACRO)
        private val NUMBER_KEYS = arrayOf(NUMBER)
        private val OPCODES_KEYS = arrayOf(OPCODE)
    }


    override fun getHighlightingLexer() = CA65LexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when (tokenType) {
            CA65Types.STRING -> STRING_KEYS
            CA65Types.COMMENT -> COMMENT_KEYS
            CA65Types.MACRO_PROC, CA65Types.MACRO_INCLUDE -> MACRO_KEYS
            CA65Types.HEX_NUMBER, CA65Types.BIN_NUMBER, CA65Types.DEC_NUMBER -> NUMBER_KEYS
            CA65Types.OPCODE -> OPCODES_KEYS
            TokenType.BAD_CHARACTER -> BAD_CHAR_KEYS
            else -> EMPTY_KEYS
        }
    }
}
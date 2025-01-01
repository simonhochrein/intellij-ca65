package com.simonhochrein.intellijca65.language.ca65

import com.intellij.psi.TokenType
import com.intellij.psi.tree.TokenSet
import com.simonhochrein.intellijca65.language.ca65.psi.CA65Types

object CA65TokenSets {
    val COMMENTS = TokenSet.create(CA65Types.COMMENT)
    val WHITESPACE = TokenSet.create(CA65Types.NEWLINE, TokenType.WHITE_SPACE)
}
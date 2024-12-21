package com.simonhochrein.intellijca65.language.ca65

import com.intellij.psi.tree.TokenSet
import com.simonhochrein.intellijca65.language.ca65.psi.CA65Types

object CA65TokenSets {
    val IDENTIFIERS = TokenSet.create(CA65Types.KEY)
    val COMMENTS = TokenSet.create(CA65Types.COMMENT)
}
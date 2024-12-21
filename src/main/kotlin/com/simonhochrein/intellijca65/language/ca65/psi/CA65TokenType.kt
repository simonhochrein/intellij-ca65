package com.simonhochrein.intellijca65.language.ca65.psi

import com.intellij.psi.tree.IElementType
import com.simonhochrein.intellijca65.language.ca65.CA65Language

class CA65TokenType(debugName: String) : IElementType(debugName, CA65Language.INSTANCE) {
    override fun toString() = "CA65TokenType."+super.toString()
}
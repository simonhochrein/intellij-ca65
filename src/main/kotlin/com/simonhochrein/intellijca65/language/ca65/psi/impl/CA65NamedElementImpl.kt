package com.simonhochrein.intellijca65.language.ca65.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.Key
import com.simonhochrein.intellijca65.language.ca65.psi.CA65NamedElement

abstract class CA65NamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), CA65NamedElement
// This is a generated file. Not intended for manual editing.
package com.simonhochrein.intellijca65.language.ca65.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import generated.psi.impl.*;

public interface CA65Types {

  IElementType PROPERTY = new CA65ElementType("PROPERTY");

  IElementType COMMENT = new CA65TokenType("COMMENT");
  IElementType CRLF = new CA65TokenType("CRLF");
  IElementType KEY = new CA65TokenType("KEY");
  IElementType SEPARATOR = new CA65TokenType("SEPARATOR");
  IElementType VALUE = new CA65TokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new CA65PropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

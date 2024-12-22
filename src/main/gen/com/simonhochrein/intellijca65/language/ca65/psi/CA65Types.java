// This is a generated file. Not intended for manual editing.
package com.simonhochrein.intellijca65.language.ca65.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.simonhochrein.intellijca65.language.ca65.psi.impl.*;

public interface CA65Types {

  IElementType CONSTANT = new CA65ElementType("CONSTANT");
  IElementType EXPRESSION = new CA65ElementType("EXPRESSION");
  IElementType IMMEDIATE = new CA65ElementType("IMMEDIATE");
  IElementType INCLUDE = new CA65ElementType("INCLUDE");
  IElementType INSTRUCTION = new CA65ElementType("INSTRUCTION");
  IElementType LABEL = new CA65ElementType("LABEL");
  IElementType LINE_COMMENT = new CA65ElementType("LINE_COMMENT");
  IElementType NUMBER = new CA65ElementType("NUMBER");
  IElementType PROC = new CA65ElementType("PROC");
  IElementType SECTION = new CA65ElementType("SECTION");

  IElementType BIN_NUMBER = new CA65TokenType("BIN_NUMBER");
  IElementType COLON = new CA65TokenType("COLON");
  IElementType COMMENT = new CA65TokenType("COMMENT");
  IElementType DEC_NUMBER = new CA65TokenType("DEC_NUMBER");
  IElementType EQUALS = new CA65TokenType("EQUALS");
  IElementType HASH = new CA65TokenType("HASH");
  IElementType HEX_NUMBER = new CA65TokenType("HEX_NUMBER");
  IElementType IDENTIFIER = new CA65TokenType("IDENTIFIER");
  IElementType MACRO_INCLUDE = new CA65TokenType("MACRO_INCLUDE");
  IElementType MACRO_PROC = new CA65TokenType("MACRO_PROC");
  IElementType MACRO_PROCEND = new CA65TokenType("MACRO_PROCEND");
  IElementType NEWLINE = new CA65TokenType("NEWLINE");
  IElementType OPCODE = new CA65TokenType("OPCODE");
  IElementType STRING = new CA65TokenType("STRING");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == CONSTANT) {
        return new CA65ConstantImpl(node);
      }
      else if (type == EXPRESSION) {
        return new CA65ExpressionImpl(node);
      }
      else if (type == IMMEDIATE) {
        return new CA65ImmediateImpl(node);
      }
      else if (type == INCLUDE) {
        return new CA65IncludeImpl(node);
      }
      else if (type == INSTRUCTION) {
        return new CA65InstructionImpl(node);
      }
      else if (type == LABEL) {
        return new CA65LabelImpl(node);
      }
      else if (type == LINE_COMMENT) {
        return new CA65LineCommentImpl(node);
      }
      else if (type == NUMBER) {
        return new CA65NumberImpl(node);
      }
      else if (type == PROC) {
        return new CA65ProcImpl(node);
      }
      else if (type == SECTION) {
        return new CA65SectionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}

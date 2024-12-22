// This is a generated file. Not intended for manual editing.
package com.simonhochrein.intellijca65.language.ca65.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class CA65Visitor extends PsiElementVisitor {

  public void visitConstant(@NotNull CA65Constant o) {
    visitPsiElement(o);
  }

  public void visitExpression(@NotNull CA65Expression o) {
    visitPsiElement(o);
  }

  public void visitImmediate(@NotNull CA65Immediate o) {
    visitPsiElement(o);
  }

  public void visitInclude(@NotNull CA65Include o) {
    visitPsiElement(o);
  }

  public void visitInstruction(@NotNull CA65Instruction o) {
    visitPsiElement(o);
  }

  public void visitLabel(@NotNull CA65Label o) {
    visitPsiElement(o);
  }

  public void visitLineComment(@NotNull CA65LineComment o) {
    visitPsiElement(o);
  }

  public void visitNumber(@NotNull CA65Number o) {
    visitPsiElement(o);
  }

  public void visitProc(@NotNull CA65Proc o) {
    visitPsiElement(o);
  }

  public void visitSection(@NotNull CA65Section o) {
    visitNamedElement(o);
  }

  public void visitNamedElement(@NotNull CA65NamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}

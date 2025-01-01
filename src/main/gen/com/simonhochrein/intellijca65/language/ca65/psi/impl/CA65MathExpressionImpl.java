// This is a generated file. Not intended for manual editing.
package com.simonhochrein.intellijca65.language.ca65.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.simonhochrein.intellijca65.language.ca65.psi.CA65Types.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.simonhochrein.intellijca65.language.ca65.psi.*;

public class CA65MathExpressionImpl extends ASTWrapperPsiElement implements CA65MathExpression {

  public CA65MathExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CA65Visitor visitor) {
    visitor.visitMathExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CA65Visitor) accept((CA65Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<CA65BitwiseOperator> getBitwiseOperatorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CA65BitwiseOperator.class);
  }

  @Override
  @NotNull
  public List<CA65NamespacedIdentifier> getNamespacedIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CA65NamespacedIdentifier.class);
  }

  @Override
  @NotNull
  public List<CA65Number> getNumberList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CA65Number.class);
  }

}

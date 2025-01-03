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

public class CA65ExpressionImpl extends ASTWrapperPsiElement implements CA65Expression {

  public CA65ExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CA65Visitor visitor) {
    visitor.visitExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CA65Visitor) accept((CA65Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CA65Expression getExpression() {
    return findChildByClass(CA65Expression.class);
  }

  @Override
  @Nullable
  public CA65Immediate getImmediate() {
    return findChildByClass(CA65Immediate.class);
  }

  @Override
  @Nullable
  public CA65MathExpression getMathExpression() {
    return findChildByClass(CA65MathExpression.class);
  }

  @Override
  @Nullable
  public CA65NamespacedIdentifier getNamespacedIdentifier() {
    return findChildByClass(CA65NamespacedIdentifier.class);
  }

  @Override
  @Nullable
  public CA65Number getNumber() {
    return findChildByClass(CA65Number.class);
  }

}

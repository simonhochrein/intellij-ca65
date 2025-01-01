// This is a generated file. Not intended for manual editing.
package com.simonhochrein.intellijca65.language.ca65.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.simonhochrein.intellijca65.language.ca65.psi.CA65Types.*;
import com.simonhochrein.intellijca65.language.ca65.psi.*;
import com.intellij.psi.PsiReference;

public class CA65NamespacedIdentifierImpl extends CA65NamedElementImpl implements CA65NamespacedIdentifier {

  public CA65NamespacedIdentifierImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CA65Visitor visitor) {
    visitor.visitNamespacedIdentifier(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CA65Visitor) accept((CA65Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public String getName() {
    return CA65PsiImplUtilKt.getName(this);
  }

  @Override
  @NotNull
  public CA65NamespacedIdentifier setName(@NotNull String name) {
    return CA65PsiImplUtilKt.setName(this, name);
  }

  @Override
  @NotNull
  public PsiElement getNameIdentifier() {
    return CA65PsiImplUtilKt.getNameIdentifier(this);
  }

  @Override
  @NotNull
  public PsiReference[] getReferences() {
    return CA65PsiImplUtilKt.getReferences(this);
  }

}

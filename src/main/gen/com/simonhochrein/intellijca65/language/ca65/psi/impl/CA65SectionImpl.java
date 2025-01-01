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
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.util.NlsSafe;

public class CA65SectionImpl extends CA65NamedElementImpl implements CA65Section {

  public CA65SectionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CA65Visitor visitor) {
    visitor.visitSection(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CA65Visitor) accept((CA65Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<CA65Instruction> getInstructionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CA65Instruction.class);
  }

  @Override
  @NotNull
  public CA65Label getLabel() {
    return findNotNullChildByClass(CA65Label.class);
  }

  @Override
  @NotNull
  public List<CA65LineComment> getLineCommentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CA65LineComment.class);
  }

  @Override
  @NotNull
  public @NlsSafe String getKey() {
    return CA65PsiImplUtilKt.getKey(this);
  }

  @Override
  @NotNull
  public String getName() {
    return CA65PsiImplUtilKt.getName(this);
  }

  @Override
  @NotNull
  public CA65Section setName(@NotNull String name) {
    return CA65PsiImplUtilKt.setName(this, name);
  }

  @Override
  @Nullable
  public PsiElement getNameIdentifier() {
    return CA65PsiImplUtilKt.getNameIdentifier(this);
  }

  @Override
  @NotNull
  public ItemPresentation getPresentation() {
    return CA65PsiImplUtilKt.getPresentation(this);
  }

}

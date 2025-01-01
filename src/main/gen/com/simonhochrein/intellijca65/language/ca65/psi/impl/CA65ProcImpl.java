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

public class CA65ProcImpl extends CA65NamedElementImpl implements CA65Proc {

  public CA65ProcImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CA65Visitor visitor) {
    visitor.visitProc(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CA65Visitor) accept((CA65Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<CA65Constant> getConstantList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CA65Constant.class);
  }

  @Override
  @NotNull
  public List<CA65Include> getIncludeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CA65Include.class);
  }

  @Override
  @NotNull
  public List<CA65Instruction> getInstructionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CA65Instruction.class);
  }

  @Override
  @NotNull
  public List<CA65LineComment> getLineCommentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CA65LineComment.class);
  }

  @Override
  @NotNull
  public List<CA65Proc> getProcList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CA65Proc.class);
  }

  @Override
  @NotNull
  public List<CA65Section> getSectionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CA65Section.class);
  }

  @Override
  @NotNull
  public String getName() {
    return CA65PsiImplUtilKt.getName(this);
  }

  @Override
  @NotNull
  public CA65Proc setName(@NotNull String name) {
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

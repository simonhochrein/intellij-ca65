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

public class CA65InstructionImpl extends ASTWrapperPsiElement implements CA65Instruction {

  public CA65InstructionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CA65Visitor visitor) {
    visitor.visitInstruction(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CA65Visitor) accept((CA65Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<CA65Expression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CA65Expression.class);
  }

  @Override
  @Nullable
  public CA65LineComment getLineComment() {
    return findChildByClass(CA65LineComment.class);
  }

}

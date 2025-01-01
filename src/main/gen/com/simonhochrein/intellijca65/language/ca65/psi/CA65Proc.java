// This is a generated file. Not intended for manual editing.
package com.simonhochrein.intellijca65.language.ca65.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface CA65Proc extends CA65NamedElement {

  @NotNull
  List<CA65Constant> getConstantList();

  @NotNull
  List<CA65Include> getIncludeList();

  @NotNull
  List<CA65Instruction> getInstructionList();

  @NotNull
  List<CA65LineComment> getLineCommentList();

  @NotNull
  List<CA65Proc> getProcList();

  @NotNull
  List<CA65Section> getSectionList();

  @NotNull
  String getName();

  @NotNull
  CA65Proc setName(@NotNull String name);

  @Nullable
  PsiElement getNameIdentifier();

  @NotNull
  ItemPresentation getPresentation();

}

// This is a generated file. Not intended for manual editing.
package com.simonhochrein.intellijca65.language.ca65.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.util.NlsSafe;

public interface CA65Section extends CA65NamedElement {

  @NotNull
  List<CA65Instruction> getInstructionList();

  @NotNull
  CA65Label getLabel();

  @NotNull
  List<CA65LineComment> getLineCommentList();

  @NotNull
  @NlsSafe String getKey();

  @NotNull
  String getName();

  @NotNull
  CA65Section setName(@NotNull String name);

  @Nullable
  PsiElement getNameIdentifier();

  @NotNull
  ItemPresentation getPresentation();

}

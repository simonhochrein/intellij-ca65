// This is a generated file. Not intended for manual editing.
package com.simonhochrein.intellijca65.language.ca65.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface CA65Section extends CA65NamedElement {

  @NotNull
  List<CA65Instruction> getInstructionList();

  @NotNull
  CA65Label getLabel();

  @Nullable
  @NotNull String getKey();

  @NotNull
  String getValue();

  //WARNING: getName(...) is skipped
  //matching getName(CA65Section, ...)
  //methods are not found in CA65PsiImplUtilKt

  @NotNull
  CA65Section setName(@NotNull String name);

  @Nullable
  PsiElement getNameIdentifier();

  @NotNull
  ItemPresentation getPresentation();

}

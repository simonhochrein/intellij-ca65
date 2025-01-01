// This is a generated file. Not intended for manual editing.
package com.simonhochrein.intellijca65.language.ca65.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface CA65NamespacedIdentifier extends CA65NamedElement {

  @NotNull
  String getName();

  @NotNull
  CA65NamespacedIdentifier setName(@NotNull String name);

  @NotNull
  PsiElement getNameIdentifier();

  @NotNull
  PsiReference[] getReferences();

}

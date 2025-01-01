// This is a generated file. Not intended for manual editing.
package com.simonhochrein.intellijca65.language.ca65.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CA65Expression extends PsiElement {

  @Nullable
  CA65Expression getExpression();

  @Nullable
  CA65Immediate getImmediate();

  @Nullable
  CA65MathExpression getMathExpression();

  @Nullable
  CA65NamespacedIdentifier getNamespacedIdentifier();

  @Nullable
  CA65Number getNumber();

}

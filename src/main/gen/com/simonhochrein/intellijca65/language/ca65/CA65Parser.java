// This is a generated file. Not intended for manual editing.
package com.simonhochrein.intellijca65.language.ca65;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.simonhochrein.intellijca65.language.ca65.psi.CA65Types.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class CA65Parser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return ca65File(b, l + 1);
  }

  /* ********************************************************** */
  // item_*
  static boolean ca65File(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ca65File")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ca65File", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // identifier EQUALS expression
  public static boolean constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constant")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, EQUALS);
    r = r && expression(b, l + 1);
    exit_section_(b, m, CONSTANT, r);
    return r;
  }

  /* ********************************************************** */
  // STRING | number | immediate | IDENTIFIER
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = consumeToken(b, STRING);
    if (!r) r = number(b, l + 1);
    if (!r) r = immediate(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // HASH (number | IDENTIFIER)
  public static boolean immediate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "immediate")) return false;
    if (!nextTokenIs(b, HASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HASH);
    r = r && immediate_1(b, l + 1);
    exit_section_(b, m, IMMEDIATE, r);
    return r;
  }

  // number | IDENTIFIER
  private static boolean immediate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "immediate_1")) return false;
    boolean r;
    r = number(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    return r;
  }

  /* ********************************************************** */
  // MACRO_INCLUDE STRING NEWLINE
  public static boolean include(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include")) return false;
    if (!nextTokenIs(b, MACRO_INCLUDE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MACRO_INCLUDE, STRING, NEWLINE);
    exit_section_(b, m, INCLUDE, r);
    return r;
  }

  /* ********************************************************** */
  // OPCODE NEWLINE
  public static boolean instruction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction")) return false;
    if (!nextTokenIs(b, OPCODE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, OPCODE, NEWLINE);
    exit_section_(b, m, INSTRUCTION, r);
    return r;
  }

  /* ********************************************************** */
  // macro | constant | line_comment | section | instruction | NEWLINE
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = macro(b, l + 1);
    if (!r) r = constant(b, l + 1);
    if (!r) r = line_comment(b, l + 1);
    if (!r) r = section(b, l + 1);
    if (!r) r = instruction(b, l + 1);
    if (!r) r = consumeToken(b, NEWLINE);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER COLON NEWLINE
  public static boolean label(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "label")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, COLON, NEWLINE);
    exit_section_(b, m, LABEL, r);
    return r;
  }

  /* ********************************************************** */
  // COMMENT
  public static boolean line_comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_comment")) return false;
    if (!nextTokenIs(b, COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMENT);
    exit_section_(b, m, LINE_COMMENT, r);
    return r;
  }

  /* ********************************************************** */
  // include | proc
  static boolean macro(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro")) return false;
    if (!nextTokenIs(b, "", MACRO_INCLUDE, MACRO_PROC)) return false;
    boolean r;
    r = include(b, l + 1);
    if (!r) r = proc(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // HEX_NUMBER | BIN_NUMBER | DEC_NUMBER
  public static boolean number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER, "<number>");
    r = consumeToken(b, HEX_NUMBER);
    if (!r) r = consumeToken(b, BIN_NUMBER);
    if (!r) r = consumeToken(b, DEC_NUMBER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // MACRO_PROC NEWLINE MACRO_PROCEND
  public static boolean proc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proc")) return false;
    if (!nextTokenIs(b, MACRO_PROC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MACRO_PROC, NEWLINE, MACRO_PROCEND);
    exit_section_(b, m, PROC, r);
    return r;
  }

  /* ********************************************************** */
  // label instruction*
  public static boolean section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = label(b, l + 1);
    r = r && section_1(b, l + 1);
    exit_section_(b, m, SECTION, r);
    return r;
  }

  // instruction*
  private static boolean section_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!instruction(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "section_1", c)) break;
    }
    return true;
  }

}

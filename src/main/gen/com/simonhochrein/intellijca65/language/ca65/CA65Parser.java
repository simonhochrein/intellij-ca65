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
  // BITWISE_OR | BITWISE_AND | PLUS | MINUS | MUL | DIV
  public static boolean bitwise_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitwise_operator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BITWISE_OPERATOR, "<bitwise operator>");
    r = consumeToken(b, BITWISE_OR);
    if (!r) r = consumeToken(b, BITWISE_AND);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, DIV);
    exit_section_(b, l, m, r, false, null);
    return r;
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
  // identifier (EQUALS | LABEL_ASSIGNMENT) expression
  public static boolean constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constant")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && constant_1(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, CONSTANT, r);
    return r;
  }

  // EQUALS | LABEL_ASSIGNMENT
  private static boolean constant_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constant_1")) return false;
    boolean r;
    r = consumeToken(b, EQUALS);
    if (!r) r = consumeToken(b, LABEL_ASSIGNMENT);
    return r;
  }

  /* ********************************************************** */
  // (OPEN_PAREN expression CLOSE_PAREN) | (OPEN_BRACE expression CLOSE_BRACE) | math_expression | STRING | number | immediate | namespaced_identifier
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = expression_0(b, l + 1);
    if (!r) r = expression_1(b, l + 1);
    if (!r) r = math_expression(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = number(b, l + 1);
    if (!r) r = immediate(b, l + 1);
    if (!r) r = namespaced_identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OPEN_PAREN expression CLOSE_PAREN
  private static boolean expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_PAREN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, CLOSE_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // OPEN_BRACE expression CLOSE_BRACE
  private static boolean expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_BRACE);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, CLOSE_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // HASH expression
  public static boolean immediate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "immediate")) return false;
    if (!nextTokenIs(b, HASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HASH);
    r = r && expression(b, l + 1);
    exit_section_(b, m, IMMEDIATE, r);
    return r;
  }

  /* ********************************************************** */
  // MACRO_INCLUDE string_literal (line_comment | NEWLINE)
  public static boolean include(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include")) return false;
    if (!nextTokenIs(b, MACRO_INCLUDE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MACRO_INCLUDE);
    r = r && string_literal(b, l + 1);
    r = r && include_2(b, l + 1);
    exit_section_(b, m, INCLUDE, r);
    return r;
  }

  // line_comment | NEWLINE
  private static boolean include_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_2")) return false;
    boolean r;
    r = line_comment(b, l + 1);
    if (!r) r = consumeToken(b, NEWLINE);
    return r;
  }

  /* ********************************************************** */
  // (
  // 	PSEUDO_INSTRUCTION expression (COMMA expression)*
  // 	| PSEUDO_INSTRUCTION
  // 	| IDENTIFIER expression (COMMA expression)*
  // 	| IDENTIFIER
  // 	| OPCODE expression (COMMA expression)*
  // 	| OPCODE
  // ) line_comment? NEWLINE
  public static boolean instruction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INSTRUCTION, "<instruction>");
    r = instruction_0(b, l + 1);
    r = r && instruction_1(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PSEUDO_INSTRUCTION expression (COMMA expression)*
  // 	| PSEUDO_INSTRUCTION
  // 	| IDENTIFIER expression (COMMA expression)*
  // 	| IDENTIFIER
  // 	| OPCODE expression (COMMA expression)*
  // 	| OPCODE
  private static boolean instruction_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = instruction_0_0(b, l + 1);
    if (!r) r = consumeToken(b, PSEUDO_INSTRUCTION);
    if (!r) r = instruction_0_2(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = instruction_0_4(b, l + 1);
    if (!r) r = consumeToken(b, OPCODE);
    exit_section_(b, m, null, r);
    return r;
  }

  // PSEUDO_INSTRUCTION expression (COMMA expression)*
  private static boolean instruction_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PSEUDO_INSTRUCTION);
    r = r && expression(b, l + 1);
    r = r && instruction_0_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA expression)*
  private static boolean instruction_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_0_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!instruction_0_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "instruction_0_0_2", c)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean instruction_0_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_0_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER expression (COMMA expression)*
  private static boolean instruction_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && expression(b, l + 1);
    r = r && instruction_0_2_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA expression)*
  private static boolean instruction_0_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_0_2_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!instruction_0_2_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "instruction_0_2_2", c)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean instruction_0_2_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_0_2_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OPCODE expression (COMMA expression)*
  private static boolean instruction_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_0_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPCODE);
    r = r && expression(b, l + 1);
    r = r && instruction_0_4_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA expression)*
  private static boolean instruction_0_4_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_0_4_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!instruction_0_4_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "instruction_0_4_2", c)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean instruction_0_4_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_0_4_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // line_comment?
  private static boolean instruction_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction_1")) return false;
    line_comment(b, l + 1);
    return true;
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
  // IDENTIFIER COLON
  public static boolean label(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "label")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, COLON);
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
  // (namespaced_identifier | number) (bitwise_operator (namespaced_identifier | number))+
  public static boolean math_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATH_EXPRESSION, "<math expression>");
    r = math_expression_0(b, l + 1);
    r = r && math_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // namespaced_identifier | number
  private static boolean math_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_expression_0")) return false;
    boolean r;
    r = namespaced_identifier(b, l + 1);
    if (!r) r = number(b, l + 1);
    return r;
  }

  // (bitwise_operator (namespaced_identifier | number))+
  private static boolean math_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_expression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = math_expression_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!math_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "math_expression_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // bitwise_operator (namespaced_identifier | number)
  private static boolean math_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bitwise_operator(b, l + 1);
    r = r && math_expression_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // namespaced_identifier | number
  private static boolean math_expression_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_expression_1_0_1")) return false;
    boolean r;
    r = namespaced_identifier(b, l + 1);
    if (!r) r = number(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (NAMESPACE_SEPARATOR IDENTIFIER)* | (NAMESPACE_SEPARATOR IDENTIFIER)+
  public static boolean namespaced_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespaced_identifier")) return false;
    if (!nextTokenIs(b, "<namespaced identifier>", IDENTIFIER, NAMESPACE_SEPARATOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMESPACED_IDENTIFIER, "<namespaced identifier>");
    r = namespaced_identifier_0(b, l + 1);
    if (!r) r = namespaced_identifier_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER (NAMESPACE_SEPARATOR IDENTIFIER)*
  private static boolean namespaced_identifier_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespaced_identifier_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && namespaced_identifier_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (NAMESPACE_SEPARATOR IDENTIFIER)*
  private static boolean namespaced_identifier_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespaced_identifier_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!namespaced_identifier_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "namespaced_identifier_0_1", c)) break;
    }
    return true;
  }

  // NAMESPACE_SEPARATOR IDENTIFIER
  private static boolean namespaced_identifier_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespaced_identifier_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NAMESPACE_SEPARATOR, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // (NAMESPACE_SEPARATOR IDENTIFIER)+
  private static boolean namespaced_identifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespaced_identifier_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = namespaced_identifier_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!namespaced_identifier_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "namespaced_identifier_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // NAMESPACE_SEPARATOR IDENTIFIER
  private static boolean namespaced_identifier_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespaced_identifier_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NAMESPACE_SEPARATOR, IDENTIFIER);
    exit_section_(b, m, null, r);
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
  // MACRO_PROC IDENTIFIER item_* MACRO_PROCEND
  public static boolean proc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proc")) return false;
    if (!nextTokenIs(b, MACRO_PROC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MACRO_PROC, IDENTIFIER);
    r = r && proc_2(b, l + 1);
    r = r && consumeToken(b, MACRO_PROCEND);
    exit_section_(b, m, PROC, r);
    return r;
  }

  // item_*
  private static boolean proc_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proc_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "proc_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // label (line_comment | instruction | NEWLINE)*
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

  // (line_comment | instruction | NEWLINE)*
  private static boolean section_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!section_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "section_1", c)) break;
    }
    return true;
  }

  // line_comment | instruction | NEWLINE
  private static boolean section_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section_1_0")) return false;
    boolean r;
    r = line_comment(b, l + 1);
    if (!r) r = instruction(b, l + 1);
    if (!r) r = consumeToken(b, NEWLINE);
    return r;
  }

  /* ********************************************************** */
  // STRING
  public static boolean string_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, STRING_LITERAL, r);
    return r;
  }

}

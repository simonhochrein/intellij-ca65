package com.simonhochrein.intellijca65.language.ca65;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.simonhochrein.intellijca65.language.ca65.psi.CA65Types;
import com.intellij.psi.TokenType;

%%

%class CA65Lexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

WHITE_SPACE=[\ \t\f\r]
COMMENT=;.*
NEWLINE=\n
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*

HEX_NUMBER=\$[0-9A-Fa-f]+
BIN_NUMBER=\%[01]+
DEC_NUMBER=[0-9]+
STRING=\".*\"
OPCODE=(adc|and|asl|bcc|bcs|beq|bit|bni|bne|bpl|brk|bvc|bvs|clc|cld|cli|clv|cmp|cpx|cpy|dec|dex|dey|eor|inc|inx|iny|jmp|jsr|lda|ldx|ldy|lsr|nop|ora|pha|php|pla|plp|rol|ror|rti|rts|sbc|sec|sed|sei|sta|stx|sty|tax|tay|tsx|txa|txs|tya)

%state WAITING_VALUE
%state WAITING_NEWLINE

%%

<WAITING_NEWLINE> {
	{NEWLINE} { yybegin(YYINITIAL); return CA65Types.NEWLINE; }
}
<YYINITIAL> {
	{COMMENT} { yybegin(WAITING_NEWLINE); return CA65Types.COMMENT; }
	{NEWLINE} { return CA65Types.NEWLINE; }
	, { return CA65Types.COMMA; }
    := { return CA65Types.LABEL_ASSIGNMENT; }
	:: { return CA65Types.NAMESPACE_SEPARATOR; }
	: { return CA65Types.COLON; }
	# { return CA65Types.HASH; }
	= { return CA65Types.EQUALS; }
	\| { return CA65Types.BITWISE_OR; }
	\& { return CA65Types.BITWISE_AND; }
	\+ { return CA65Types.PLUS; }
	\- { return CA65Types.MINUS; }
    \/ { return CA65Types.DIV; }
    \* { return CA65Types.MUL; }
	\( { return CA65Types.OPEN_PAREN; }
	\) { return CA65Types.CLOSE_PAREN; }
    \{ { return CA65Types.OPEN_BRACE; }
    \} { return CA65Types.CLOSE_BRACE; }
	\.include { return CA65Types.MACRO_INCLUDE; }
	\.proc { return CA65Types.MACRO_PROC; }
	\.endproc { return CA65Types.MACRO_PROCEND; }
	\.[a-z]+ { return CA65Types.PSEUDO_INSTRUCTION; }
	{OPCODE} { return CA65Types.OPCODE; }
	{IDENTIFIER} { return CA65Types.IDENTIFIER; }
	{HEX_NUMBER} { return CA65Types.HEX_NUMBER; }
	{BIN_NUMBER} { return CA65Types.BIN_NUMBER; }
	{DEC_NUMBER} { return CA65Types.DEC_NUMBER; }
	{STRING} { return CA65Types.STRING; }
}

{WHITE_SPACE}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
[^] { return TokenType.BAD_CHARACTER; }
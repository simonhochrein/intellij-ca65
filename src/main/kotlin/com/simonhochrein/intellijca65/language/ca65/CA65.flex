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
COMMENT=;.*\n
NEWLINE=\n
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*

HEX_NUMBER=\$[0-9A-Fa-f]+
BIN_NUMBER=\%[01]+
DEC_NUMBER=[0-9]+
STRING=\".*\"
OPCODE=(lda|sta)

%state WAITING_VALUE

%%

{NEWLINE} { return CA65Types.NEWLINE; }
: { return CA65Types.COLON; }
# { return CA65Types.HASH; }
= { return CA65Types.EQUALS; }
{COMMENT} { return CA65Types.COMMENT; }
\.include { return CA65Types.MACRO_INCLUDE; }
\.proc { return CA65Types.MACRO_PROC; }
\.endproc { return CA65Types.MACRO_PROCEND; }
{OPCODE} { return CA65Types.OPCODE; }
{IDENTIFIER} { return CA65Types.IDENTIFIER; }
{HEX_NUMBER} { return CA65Types.HEX_NUMBER; }
{BIN_NUMBER} { return CA65Types.BIN_NUMBER; }
{DEC_NUMBER} { return CA65Types.DEC_NUMBER; }
{STRING} { return CA65Types.STRING; }


{WHITE_SPACE}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
[^] { return TokenType.BAD_CHARACTER; }
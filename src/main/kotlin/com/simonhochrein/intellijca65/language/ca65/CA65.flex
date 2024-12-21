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

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=("#"|"!")[^\r\n]*
SEPARATOR=[:=]
KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "

%state WAITING_VALUE

%%

<YYINITIAL> {END_OF_LINE_COMMENT} { yybegin(YYINITIAL); return CA65Types.COMMENT; }
<YYINITIAL> {KEY_CHARACTER}+ { yybegin(YYINITIAL); return CA65Types.KEY; }
<YYINITIAL> {SEPARATOR} { yybegin(WAITING_VALUE); return CA65Types.SEPARATOR; }
<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
<WAITING_VALUE> {WHITE_SPACE}+ { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }
<WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}* { yybegin(YYINITIAL); return CA65Types.VALUE; }
({CRLF}|{WHITE_SPACE})+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
[^] { return TokenType.BAD_CHARACTER; }
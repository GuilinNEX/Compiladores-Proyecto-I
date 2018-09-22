import ProyectoI.Token.*;

%%
%class Lexer
%type Token
multiLineComment = "/*" [^*] ~"*/" | "/*" "*" + "/"
oneLineComment = "//" .* | "(*" .* "*)" | "{" .* "}"
reservedword = "AND"|"ARRAY"|"BEGIN"|"BOOLEAN"|"BYTE"|"CASE"|"CHAR"|"CONST"|"DIV"|"DO"|"DOWNTO"|"ELSE"|"END"|"FALSE"|"FILE"|
"FOR"|"FORWARD"|"FUNCTION"|"GOTO"|"IF"|"IN"|"INLINE"|"INT" |"LABEL"|"LONGINT"|"MOD"|"NIL"|"NOT"|"OF"|"OR"|"PACKED"|
"PROCEDURE"|"PROGRAM"|"READ"|"REAL"|"RECORD"|"REPEAT"|"SET"|"SHORTINT"|"STRING"|"THEN"|"TO"|"TRUE"|"TYPE"
|"UNTIL"|"VAR"|"WHILE"|"WITH"|"WRITE"|"XOR"
emptySpace = [ \t\r\n]
letter = [a-zA-Z_]
digit = [0-9]
exponent = [eE] [\+\-]? [0-9]+
float = [0-9]+ \. [0-9]+ {exponent}?
equalop = "=="
plusoneop = "++"
lessoneop = "--"
greaterorequalop = ">>=" | ">="
lessorequalop = "<<=" | "<="
greaterop = ">>" | ">"
lessop = "<<" | "<"
distinctop = "<>"
additionop = "+=" | "+"
subtractionop = "-=" | "-"
multiplicationop = "*=" | "*"
divisionop = "/=" | "/"
assignop = "=" | ":="
leftpar = "("
rightpar = ")"
leftsqu = "["
rightsqu = "]"
coma = ","
semicolon = ";"
colon = ":"
point = "."
%{
public String lexeme;
%}
%%
{reservedword} {lexeme = yytext(); return RESERVEDWORDS}
{emptySpace} {/*Ignore*/}
({multiLineComment} | {oneLineComment}) {/*Ignore*/}
{equalop} {lexeme = yytext(); return EQUALSOP;}
{plusoneop} {lexeme = yytext(); return PLUSONEOP;}
{lessoneop} {lexeme = yytext(); return LESSONEOP;}
{greaterorequalop} {lexeme = yytext(); return GREATEROREQUALOP;}
{lessorequalop} {lexeme = yytext(); return LESSOREQUALOP;}
{greaterop} {lexeme = yytext(); return GREATEROP;}
{lessop} {lexeme = yytext(); return LESSOP;}
{distinctop} {lexeme = yytext(); return DISTINCTOP;}
{additionop} {lexeme = yytext(); return ADDITIONOP;}
{subtractionop} {lexeme = yytext(); return SUBTRACTIONOP;}
{multiplicationop} {lexeme = yytext(); return MULTIPLICATIONOP;}
{divisionop} {lexeme = yytext(); return DIVISIONOP;}
{assignop} {lexeme = yytext(); return ASSIGNOP;}
{leftpar} {lexeme = yytext(); return LEFTPAR;}
{rightpar} {lexeme = yytext(); return RIGHTPAR;}
{leftsqu} {lexeme = yytext(); return LEFTSQU;}
{rightsqu} {lexeme = yytext(); return RIGHTSQU;}
{coma} {lexeme = yytext(); return COMA;}
{semicolon} {lexeme = yytext(); return SEMICOLON;}
{colon} {lexeme = yytext(); return COLON;}
{point} {lexeme = yytext(); return POINT;}
\'.*\' | \"[^*] ~\" | \#.* {lexeme = yytext(); return STRINGLIT;}
{letter} ({letter} | {digit})* {1,127} {lexeme = yytext(); return ID;}
[-]?{digit}+ {lexeme = yytext(); return INTEGERLIT;}
[-]?{float}+ {lexeme = yytext(); return FLOATLIT;}
. {return ERROR;} 
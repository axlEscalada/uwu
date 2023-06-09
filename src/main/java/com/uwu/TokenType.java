package com.uwu;

public enum TokenType{
  //Single-character tokens
  LEFT_PAREN, RIGHT_PAREN, LEFT_BRACE, RIGHT_BRACE,
  COMMA, DOT, MINUS, PLUS, SEMICOLON, SLASH, STAR,
  // One or two character tokens.
  BANG, BANG_EQUAL,
  EQUAL, EQUAL_EQUAL,
  GREATER, GREATER_EQUAL,
  LESS, LESS_EQUAL,

  //Literals
  IDENTIFIER, STRING, NUMBER,

  //Keywords uwu = print
  AND, CLASS, ELSE, FALSE, FUN, FOR, IF, NIL, OR,
  UWU, RETURN, SUPER, THIS, TRUE, VAR, WHILE,
  //End of file
  EOF

}

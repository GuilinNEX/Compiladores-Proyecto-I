package domain;

import enumeration.Token;

public class Generator 
{
	private Token token;
	private String lexer;
	
	public Generator(Token pToken, String lexeme)
	{
		this.token = pToken;
		this.lexer = lexeme;
	}
	/*
	 * GETTERS & SETTERS OF THE ATTRIBUTES
	 * */
	public Token getToken() {
		return token;
	}
	public void setToken(Token token) {
		this.token = token;
	}
	public String getLexer() {
		return lexer;
	}
	public void setLexer(String lexer) {
		this.lexer = lexer;
	}
}

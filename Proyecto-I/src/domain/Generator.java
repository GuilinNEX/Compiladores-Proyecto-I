package domain;

import enumeration.Token;

public class Generator 
{
	private Token token; //Object that storage the token
	private String lexer; //The symbol or the value
	
	/*
	 * Author: Esteban Coto Alfaro
	 * Creation Date: 22/09/2018
	 * Last Modification: 22/09/2018
	 * Description: Constructor for the Generator
	 */
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

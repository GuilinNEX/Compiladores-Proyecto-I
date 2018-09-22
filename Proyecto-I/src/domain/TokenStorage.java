package domain;

import java.util.ArrayList;

public class TokenStorage 
{
	private ArrayList<Generator> tokenList;
	private static TokenStorage instance;
	
	public TokenStorage()
	{
		tokenList = new ArrayList<Generator>();
	}
	
	//Get Instance
	public static TokenStorage getInstance()
	{
		if (instance == null)
			instance = new TokenStorage();
		return instance;
	}

	//Generate the token
	public void generateToken(Generator pGenerator)
	{
		tokenList.add(pGenerator);
	}
	
	/*
	 * GETTERS & SETTERS OF THE ATTRIBUTES
	 * */
	public ArrayList<Generator> getTokenList() {
		return tokenList;
	}

	public void setTokenList(ArrayList<Generator> tokenList) {
		this.tokenList = tokenList;
	}
}

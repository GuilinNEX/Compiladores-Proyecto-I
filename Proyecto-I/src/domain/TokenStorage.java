package domain;

import java.util.ArrayList;

public class TokenStorage 
{
	private ArrayList<Generator> tokenList; //The array attribute of the tokens and their values
	private static TokenStorage instance; //Instance of the present class
	
	/*
	 * Author: Esteban Coto Alfaro
	 * Creation Date: 22/09/2018
	 * Last Modification: 22/09/2018
	 * Description: Constructor for the TokenStorage
	 */
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

	/*
	 * Author: Esteban Coto Alfaro
	 * Creation Date: 22/09/2018
	 * Last Modification: 22/09/2018
	 * Description: Add to the arrayList a new Generator item
	 */
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

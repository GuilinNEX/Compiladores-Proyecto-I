package domain;

import java.util.ArrayList;
import java.util.HashMap;

import domain.Generator;
import enumeration.Token;

public class HashStorage 
{
	private HashMap<String, String> hashMap = new HashMap<String, String>(); //Hash Map to storag all the values
	private static HashStorage instance; //Instance of the class
	
	//Get Instance
	public static HashStorage getInstance()
	{
		if (instance == null)
			instance = new HashStorage();
		return instance;
	}
		
	/*
	 * Author: Esteban Coto Alfaro
	 * Creation Date: 22/09/2018
	 * Last Modification: 22/09/2018
	 * Description: Function that fill the hash map properly
	 */
	public void fillHashMap(ArrayList<Generator> pArrayList)
	{
		for(int i = 0; i < pArrayList.size(); i++) //Analyze every element of the Token Array List
		{
			if(!(pArrayList.get(i).getToken().equals(Token.ID))) // Every token except of identifier
			{
				if(!hashMap.containsKey(pArrayList.get(i).getToken().toString())) //If the token is not in the hash map jet
				{
					hashMap.put(pArrayList.get(i).getToken().toString(), "1"); //Set the value in 1
				}
				else
				{
					int accumulator = Integer.parseInt(hashMap.get(pArrayList.get(i).getToken().toString())) + 1; //Add one on the value
					hashMap.replace(pArrayList.get(i).getToken().toString(), hashMap.get(pArrayList.get(i).getToken().toString()), Integer.toString(accumulator)); //Alter the value
				}
			}
			else //In case the token is an identifier
			{
				if(!hashMap.containsKey(pArrayList.get(i).getLexer().toLowerCase())) //If the token is not in the hash map jet
				{
					hashMap.put(pArrayList.get(i).getLexer().toLowerCase(), "1"); // Set the value in 1
				}
				else
				{
					int accumulator = Integer.parseInt(hashMap.get(pArrayList.get(i).getLexer().toLowerCase())) + 1; //Add one on the value
					hashMap.replace(pArrayList.get(i).getLexer().toLowerCase(), hashMap.get(pArrayList.get(i).getLexer().toLowerCase()), Integer.toString(accumulator)); //Alter the value
				}
			}
		}
	}
	
	//GETTERS & SETTERS
	public HashMap<String, String> getHashMap() {
		return hashMap;
	}

	public void setHashMap(HashMap<String, String> hashMap) {
		this.hashMap = hashMap;
	}
}

package domain;

import java.util.ArrayList;
import java.util.HashMap;

import domain.Generator;
import enumeration.Token;

public class HashStorage 
{
	private HashMap<String, String> hashMap = new HashMap<String, String>();
	private static HashStorage instance;
	
	//Get Instance
		public static HashStorage getInstance()
		{
			if (instance == null)
				instance = new HashStorage();
			return instance;
		}
		
	public void fillHashMap(ArrayList<Generator> pArrayList)
	{
		for(int i = 0; i < pArrayList.size(); i++)
		{
			if(!(pArrayList.get(i).getToken().equals(Token.ID)))
			{
				if(!hashMap.containsKey(pArrayList.get(i).getToken().toString()))
				{
					hashMap.put(pArrayList.get(i).getToken().toString(), "1");
				}
				else
				{
					int accumulator = Integer.parseInt(hashMap.get(pArrayList.get(i).getToken().toString())) + 1;
					hashMap.replace(pArrayList.get(i).getToken().toString(), hashMap.get(pArrayList.get(i).getToken().toString()), Integer.toString(accumulator));
				}
			}
			else
			{
				if(!hashMap.containsKey(pArrayList.get(i).getLexer().toLowerCase()))
				{
					hashMap.put(pArrayList.get(i).getLexer().toLowerCase(), "1");
				}
				else
				{
					int accumulator = Integer.parseInt(hashMap.get(pArrayList.get(i).getLexer().toLowerCase())) + 1;
					hashMap.replace(pArrayList.get(i).getLexer().toLowerCase(), hashMap.get(pArrayList.get(i).getLexer().toLowerCase()), Integer.toString(accumulator));
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

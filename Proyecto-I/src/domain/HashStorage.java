package domain;

import java.util.ArrayList;
import java.util.HashMap;

import domain.Generator;

public class HashStorage 
{
	private HashMap<Generator, Integer> hashMap = new HashMap<Generator, Integer>();
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
			if(!hashMap.containsKey(pArrayList.get(i).getToken()))
			{
				hashMap.put(pArrayList.get(i), 1);
			}
			else
			{
				hashMap.put(pArrayList.get(i), hashMap.get(pArrayList.get(i)) + 1);
			}
		}
	}
	
	//GETTERS & SETTERS
	public HashMap<Generator, Integer> getHashMap() {
		return hashMap;
	}

	public void setHashMap(HashMap<Generator, Integer> hashMap) {
		this.hashMap = hashMap;
	}
}

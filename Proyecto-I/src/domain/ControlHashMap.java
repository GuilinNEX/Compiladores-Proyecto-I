package domain;

import java.util.ArrayList;

public class ControlHashMap 
{
	public void fillHashMap(ArrayList<Generator> pArrayList)
	{
		HashStorage hashStorage = HashStorage.getInstance();
		hashStorage.fillHashMap(pArrayList);
	}
}

package domain;

import java.util.ArrayList;

public class ControlHashMap 
{
	/*
	 * Author: Esteban Coto Alfaro
	 * Creation Date: 22/09/2018
	 * Last Modification: 22/09/2018
	 * Description: Control for fill the HashMap
	 */
	public void fillHashMap(ArrayList<Generator> pArrayList)
	{
		HashStorage hashStorage = HashStorage.getInstance(); //Get the instance
		hashStorage.fillHashMap(pArrayList); //Call the method onece getting the instance
	}
}

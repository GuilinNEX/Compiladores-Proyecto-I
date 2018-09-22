package domain;

import java.util.ArrayList;

public class MainControl 
{
	private ControlGenerator controlGenerator; //Constructor of the Token generator
	private ControlHashMap controlHashMap; //Constructor of the hashMap
	private static MainControl instance; //Instance for the present class
	
	private MainControl()
	{
		controlGenerator = new ControlGenerator();
		controlHashMap = new ControlHashMap();
	}
	
	//Get Instance
	public static MainControl getInstance()
	{
		if(instance == null)
			instance = new MainControl();
		return instance;
	}
	
	/*
	 * Author: Esteban Coto Alfaro
	 * Creation Date: 22/09/2018
	 * Last Modification: 22/09/2018
	 * Description: Function to add a new generator token to the array List
	 */
	public void newToken(Generator pGenerator)
	{
		controlGenerator.newToken(pGenerator); //Send the information to the controlGenerator
	}
	
	/*
	 * Author: Esteban Coto Alfaro
	 * Creation Date: 22/09/2018
	 * Last Modification: 22/09/2018
	 * Description: Function to fill the hashmap
	 */
	public void fillHashMap(ArrayList<Generator> pArrayList)
	{
		controlHashMap.fillHashMap(pArrayList); //Send the information to the controlHashMap
	}
}

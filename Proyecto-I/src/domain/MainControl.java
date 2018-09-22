package domain;

import java.util.ArrayList;

public class MainControl 
{
	private ControlGenerator controlGenerator;
	private ControlHashMap controlHashMap;
	private static MainControl instance;
	
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
	
	public void newToken(Generator pGenerator)
	{
		controlGenerator.newToken(pGenerator);
	}
	
	public void fillHashMap(ArrayList<Generator> pArrayList)
	{
		controlHashMap.fillHashMap(pArrayList);
	}
}

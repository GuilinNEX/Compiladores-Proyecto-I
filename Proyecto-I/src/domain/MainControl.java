package domain;

public class MainControl 
{
	private ControlGenerator controlGenerator;
	private static MainControl instance;
	
	private MainControl()
	{
		controlGenerator = new ControlGenerator();
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
}

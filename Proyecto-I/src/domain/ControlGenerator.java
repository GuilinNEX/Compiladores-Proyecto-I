package domain;

public class ControlGenerator 
{

	/*
	 * Author: Esteban Coto Alfaro
	 * Creation Date: 22/09/2018
	 * Last Modification: 22/09/2018
	 * Description: Control for add a new token to the Array List
	 */
	public void newToken(Generator pGenerator)
	{
		TokenStorage tokenStorage = TokenStorage.getInstance(); //Get the instance
		tokenStorage.generateToken(pGenerator); //Call the method once getting the instance
	}
}

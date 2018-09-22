package domain;

public class ControlGenerator 
{

	public void newToken(Generator pGenerator)
	{
		TokenStorage tokenStorage = TokenStorage.getInstance();
		tokenStorage.generateToken(pGenerator);
	}
}

package domain;

import java.io.File;

import userInterface.MainWindow;

public class Main
{
	/*
	 * Author: Esteban Coto Alfaro
	 * Creation Date: 16/09/2018
	 * Last Modification: 17/09/2018
	 * Description: Main function that create the Lexer.java
	 */
	public static void main(String[] args)
	{
		String path = "C:/Users/esteb/Documents/2018 - II SEMESTRE/Compiladores/Proyecto I/Proyecto-I/src/domain/Lexer.flex";
		lexerGenerator(path);
	}
	
	/*
	 * Author: Esteban Coto Alfaro
	 * Creation Date: 16/09/2018
	 * Last Modification: 17/09/2018
	 * Description: function that create the Lexer.java with the path in the directory
	 */	
	public static void lexerGenerator(String pPath)
	{
		File file = new File(pPath);
		jflex.Main.generate(file);
	}
}

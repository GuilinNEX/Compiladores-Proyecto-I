package domain;

import java.io.File;

import userInterface.MainWindow;

public class Main
{
	public static void main(String[] args)
	{
		String path = "C:/Users/esteb/Documents/2018 - II SEMESTRE/Compiladores/Proyecto I/Proyecto-I/src/domain/Lexer.flex";
		lexerGenerator(path);
	}
	
	public static void lexerGenerator(String pPath)
	{
		File file = new File(pPath);
		jflex.Main.generate(file);
	}
}

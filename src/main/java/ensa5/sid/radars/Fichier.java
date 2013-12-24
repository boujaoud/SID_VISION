package ensa5.sid.radars;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/*1ere etape*/

public class Fichier
{
	public static void ecrire(String path, String text) 
	{
		PrintWriter ecri ;
		try
		{
			ecri = new PrintWriter(new FileWriter(path));
			ecri.write(text);
			ecri.flush();
			ecri.close();
		}//try
		catch (NullPointerException a)
		{
			System.out.println("Erreur : pointeur null");
		}
		catch (IOException a)
		{
			System.out.println("Probl�me d'IO");
		}
	}//ecrire
 
	public String lire (String path) 
	{
		BufferedReader lect ;
		String tmp = "";
		try
		{
			lect = new BufferedReader(new FileReader(path)) ;
			while (lect.ready()==true) 
			{
				tmp += lect.readLine() ; 
			}//while
		}//try
		catch (NullPointerException a)
		{
			System.out.println("Erreur : pointeur null");
		}
		catch (IOException a) 
		{
			System.out.println("Probl�me d'IO");
		}
		return tmp;
	}//lecture 
}//class

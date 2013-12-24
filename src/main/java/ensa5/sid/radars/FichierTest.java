package ensa5.sid.radars;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class FichierTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File fichier  = new File("C:/Users/Moulid/Desktop/file.txt");
		fichier.createNewFile();
		PrintWriter out = new PrintWriter(new FileWriter(fichier)) ; 
				out.write("Bonjour") ; //�cris bonjour dans le fichier 
				out.println() ; //fais un retour � la ligne dans le fichier 
				out.write("Comment allez vous") ; //�cris dans le fichier 
				out.close();
	}

}

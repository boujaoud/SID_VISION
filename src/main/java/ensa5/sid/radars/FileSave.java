package ensa5.sid.radars;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;


public class FileSave{

public void CreerFichier(String txt){
try{


String teee = "D:/SynergieStage/downloads/Dropbox/brevets.txt";//nomfichier.text


PrintWriter fich;


fich = new PrintWriter(new BufferedWriter(new FileWriter(teee, true))); //true c'est elle qui permet d'�crire � la suite des donn�e enregistrer et non de les remplac� 

fich.println(txt);


fich.close();

}catch(Exception e){
	
}



}


} 


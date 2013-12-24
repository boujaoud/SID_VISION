package ensa5.sid.radars;
/*import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;*/
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.jsoup.Jsoup;
//import org.jsoup.nodes.*;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jsoup.select.Elements;


public class ExtractToBDD {
	
	private static org.jsoup.nodes.Document lireDocument(String url) {
 		try {
			org.jsoup.nodes.Document doc = Jsoup.connect(url).get();
			return doc;
		} catch (IOException e) {
			e.printStackTrace();
		}
 
		return null;
	}
	
	/**
	 * @param args
	 */
	static Document doc =null;
	 static Element racine = new Element("Data");
	   //On crée un nouveau Document JDOM basé sur la racine que l'on vient de créer

	 static org.jdom2.Document document = new Document(racine);
	
		@SuppressWarnings("unchecked")
		//static int k=1;
		public static void main(String[] args) throws IOException {
			Connexion Cn= new Connexion();
		int k=1;
		for(int i= 1; i<=18;i++){
			
		org.jsoup.nodes.Document doc1 = lireDocument("http://patft.uspto.gov/netacgi/nph-Parser?Sect1=PTO2&Sect2=HITOFF&p=1&u=%2Fnetahtml%2FPTO%2Fsearch-bool.html&r="+i+"&f=G&l=50&co1=AND&d=PTXT&s1=%22radars%22&s2=%22anticollision%22&OS=%22radars%22+AND+%22anticollision%22&RS=%22radars%22+AND+%22anticollision%22");
	   	String file = doc1.html();
	    /////////////////////      Extraction des donnees        //////////////////////////////
	    
		org.jsoup.nodes.Document doc = Jsoup.parse(file);
		Elements el1 = doc.select("body");
		Elements el = doc.select("font").attr("size", "+1");
		Elements el2 = el1.select("tbody");
		Elements links = el2.select("td").attr("align", "RIGHT");
		Elements elem = links.select("b");
		
		//////////////////////     Creation des sous elements      ////////////////////////////
	
		/*extraire titre*/
     String titre=el.get(4).text();
     System.out.println("titre:"+titre+"\n");
     String[] titre_dec=titre.split(" ");
     
     
     /*extraire date année seulement*/
     
     String dat=elem.get(3).text();
     String[] date_dec=dat.split(" ");
     String date =date_dec[2];
     
     
     Cn.stockerItem(k++,date,0,2);
     
     
	 System.out.println("date:"+date+"\n");
	 
	 
	   int compteur = 0;
	   ArrayList auteurs = new ArrayList();
	   
	      for (org.jsoup.nodes.Element link : elem){ 
	  		if(link.text().contains(";")){
	  			 String aut=(String)link.text();
	  		     String[] aut_dec=aut.split(";");
	  		     
	  		     
	  			auteurs.add(aut_dec[0]+" "+aut_dec[1]);
	  			 System.out.println("auteur:"+link.text());
	  		  compteur++;
	  		  }
		   }
	     
	      
	    ArrayList<Collaboration> col_aray =new ArrayList<Collaboration>();  
	   
	    
	    int[] tit = new int[titre_dec.length];
	    
	    
	    for (int t=0;t<titre_dec.length;t++)
  	  {
	    	int e=k++;
  		   Cn.stockerItem(e, (String)titre_dec[t],0,1);
  		   tit[t]=e;
  		  
  	  }
	    ArrayList<Integer> li = new ArrayList<Integer>();
	    
	    for(int j=0; j<auteurs.size();j++)
	    {    int h=k++;
	    	Cn.stockerItem(h, (String)auteurs.get(j),0,3);
	    	
	    	li.add(h);  
	    	for (int t=0;t<tit.length;t++)
	    	  	  {
	      Collaboration col= new Collaboration(); 	    
	      col.setNumero_1(h);
  		  col.setNumero_2(tit[t]);
  		  col.setDate(date);
  		  col_aray.add(col);
	    	  	  }	  
	    	
	    }
	    String assigne= elem.get(compteur*2+4).text();
	    
	    Cn.stockerItem(k++,assigne,0,4);
	    
	    System.out.println("assigne:"+assigne+"\n");
	      
	      String pays =elem.get(5).text();
	      System.out.println("pays:"+pays+"\n");
	      Cn.stockerItem(k++, pays,0,5);
	     
	for(int p=0;p<li.size()-1;p++)
	{
		for(int n=p+1;n<li.size();n++)
		{ 
			Collaboration col= new Collaboration(); 	
			col.setNumero_1(li.get(p));
	  		  col.setNumero_2(li.get(n));
	  		  col.setDate(date);
	  		  col_aray.add(col);
		}
	}
	for(int o=0;o<col_aray.size();o++)
	{
		Cn.stockerCollaboration(col_aray.get(o).getNumero_1(), col_aray.get(o).getNumero_2(), col_aray.get(o).getNbr_collaboration(), col_aray.get(o).getDate());
		
		
	}
	
	
	}
	}
	
}
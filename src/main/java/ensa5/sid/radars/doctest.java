package ensa5.sid.radars;
import java.io.IOException;

import java.util.Map;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class doctest 
{
 public static void main(String args[]) 
{
	 Document doc=null;
//for(int j=1;j<=48;j++){
//	System.out.println("------------------------------------");
	 try {
		// doc = Jsoup.connect("http://patentscope.wipo.int/search/fr/result.jsf").get();
			 doc = Jsoup.connect("http://patentscope.wipo.int/search/en/detail.jsf;jsessionid=D26C94F71CC1C3CC8955A502C459937F.wapp1?docId=WO2013165356&recNum=8&office=&queryString=&prevFilter=&sortOption=Pub+Date+Desc&maxRec=32980036").get();

		System.out.println("jsoup");

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
//	Elements elements1 = doc.select("body");
	Elements elements2 = doc.select("div").attr("id","mytable");
	Elements elements3 = elements2.get(0).select("tbody");
	Elements elements = elements3.get(0).select("tr");
	System.out.println(elements2.get(150));

	
	

	   // System.out.println( element6.get(i).select("td").get(2).select("a").attr("href").substring(11,59).toString());
		//          System.out.println( elements2.get(0));
                              

 
    }
}
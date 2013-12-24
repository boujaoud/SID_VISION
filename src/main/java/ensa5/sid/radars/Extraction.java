package ensa5.sid.radars;
import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class Extraction {
	private static Document lireDocument(String url) {
		 
		 
		try {
			Document doc = Jsoup.connect(url).get();
			return doc;
		} catch (IOException e) {
			e.printStackTrace();
		}
 
		return null;
	}

	/**
	 * @param args
	 */

/*apres avoir fait ca */
	static Document doc =null;
	
	 private static String trim(String s, int width) {
	        if (s.length() > width)
	            return s.substring(0, width-1) + ".";
	        else
	            return s;
	    }
	 
	 private static void print(String msg, Object... args) {
	        System.out.println(String.format(msg, args));
	    }
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//doc = lireDocument("http://patft.uspto.gov/netacgi/nph-Parser?Sect1=PTO2&Sect2=HITOFF&p=1&u=%2Fnetahtml%2FPTO%2Fsearch-bool.html&r=0&f=S&l=50&TERM1=%22radars%22&FIELD1=&co1=AND&TERM2=%22anticollision%22&FIELD2=&d=PTXT");
		doc = Jsoup.connect("http://www.wipo.int/tools/en/gsearch.html?cx=000395567151317721298%3Aaqrs59qtjb0&cof=FORID%3A11&q=%22radars%22+and+%22anticollision%22&siteurl=www.wipo.int%2Ftools%2Fen%2Fgsearch.html%3Fcx%3D000395567151317721298%253Aaqrs59qtjb0%26cof%3DFORID%253A11%26q%3Dradars%2Band%2Banticollision&ref=www.wipo.int%2Fportal%2Fen%2Findex.html&ss=6457j14961961j4").get();
		//System.out.println(doc.html());
		Elements elements2 = doc.select("html");
		Elements el = elements2.select("iframe[name*=googleSearchFrame]");
		/*Elements el2 = el.get(0).select("div[class]");
		Elements el3 = el2.select("div[class*=content]");
		Elements el4 = el3.select("div[id*=results_000395567151317721298:aqrs59qtjb0]");*/
		int i=0;
		//Elements elements4 = elements2.get(i).select("a[href]");
		//for (org.jsoup.nodes.Element link : el) {
			//if(link.text().contains("Radar"))
			
		System.out.println("pf :"+elements2.size());
		i++;
		//}
		/*Elements elements4 = elements2.get(1).select("div").attr("id","mytable");
		Elements element5 = elements4.first().select("tbody").attr("id","resultTable:tb");
		Elements element6 = element5.select("tr");
		String text = doc.body().text();
		System.out.println( element6.get(1).select("td").get(2).select("a").attr("href"));*/
		//Elements newsHeadlines = doc.select("#mp-itn b a");
		//System.out.println("hhhh:"+newsHeadlines);
		/*Document doc1 = lireDocument("http://www.wipo.int/tools/en/gsearch.html?cx=000395567151317721298%3Aaqrs59qtjb0&cof=FORID%3A11&q=%22radars%22+and+%22anticollision%22&siteurl=www.wipo.int%2Ftools%2Fen%2Fgsearch.html%3Fcx%3D000395567151317721298%253Aaqrs59qtjb0%26cof%3DFORID%253A11%26q%3Dradars%2Band%2Banticollision&ref=www.wipo.int%2Fportal%2Fen%2Findex.html&ss=6457j14961961j4");
		System.out.println(doc1.html());
		String text1 = doc1.body().text();
		System.out.println(text1);
		//File input = new File(doc1.html());
		 * 
		 * */

		String file = doc.html();
		
		Document doc = Jsoup.parse(file);
		/*org.jsoup.nodes.Element content = doc.getElementById("content");
		Elements links = content.getElementsByTag("a");*/
		Elements links = doc.select("a[href]");
		//System.out.println(links.contains("\"radars\""));
		//if(links.contains("\"radars\"")){
		print("links size:"+links.size());
		for (org.jsoup.nodes.Element link : links) {
			//if(link.attr("href").contains("\"radars\"")){
           // print(" * a: <%s>  (%s)", link.attr("href"), trim(link.text(), 35));
			//}
         //}
		}
		/*for (org.jsoup.nodes.Element link : links) {
		  String linkHref = link.attr("href");
		  String linkText = link.text();
		  System.out.println(linkText);
		}*/
		
		/*
		String html = "http://jsoup.org";
		doc = Jsoup.connect("http://jsoup.org").get();
		org.jsoup.nodes.Element link = doc.select("a").first();

		String text = doc.body().text(); // "An example link"
		String linkHref = link.attr("href"); // "http://example.com/"
		String linkText = link.text(); // "example""

		String linkOuterH = link.outerHtml(); 
		    // "<a href="http://example.com"><b>example</b></a>"
		String linkInnerH = link.html(); // "<b>example</b>"
		System.out.println(linkInnerH);
		*/
		
		
		
		///// selection de plusieurs div  //////
		/*Document doc = Jsoup
			    .connect("http://patft.uspto.gov/netacgi/nph-Parser?Sect1=PTO2&Sect2=HITOFF&p=1&u=%2Fnetahtml%2FPTO%2Fsearch-bool.html&r=0&f=S&l=50&TERM1=%22radars%22&FIELD1=&co1=AND&TERM2=%22anticollision%22&FIELD2=&d=PTXT")
			    .header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) Gecko/20100101 Firefox/19.0")
			    .get();
			Elements divProduits = doc.select("div.prod");
		System.out.println(divProduits.size());*/
	}


}

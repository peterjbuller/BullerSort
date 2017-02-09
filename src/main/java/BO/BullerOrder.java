package BO;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BullerOrder {

	public static void main(String[] args) {

		//CarlTheSentenceGetter carl1 = new CarlTheSentenceGetter();
		String query = "sport";
		String url = "http://endic.naver.com/search_example.nhn?s"
				+ "Ln=ko&ifAjaxCall=true&isTranslatedType=1&query="+query;
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(doc.toString());
		
		
		Elements kor = doc.select(".fnt_k10 > a");
		java.util.Iterator<Element> kit = kor.iterator();
		while (kit.hasNext()) {
			System.out.println(kit.next().text());
			}
		
		Elements eng = doc.select(".mar_top01 > input[value]");
		java.util.Iterator<Element> eit = eng.iterator();
		while (eit.hasNext()) {
			System.out.println(eit.next().attr("value"));
			}

	}

}

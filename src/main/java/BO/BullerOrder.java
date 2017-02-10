package BO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BullerOrder {

	public static void main(String[] args) {

		//CarlTheSentenceGetter carl1 = new CarlTheSentenceGetter();
		String query = "sport";
		Integer pagenumber = 10;
		String url = "http://endic.naver.com/search_example.nhn"
				+ "?sLn=ko&ifAjaxCall=true&isTranslatedType=1&"
				+ "pageNo=" + pagenumber
				+ "&query="+query;
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//System.out.println(doc.toString());
		ArrayList<String[]> sentences = new ArrayList<String[]>();

		Elements kor = doc.select("div.fnt_k10 a[class$=detail]");
		java.util.Iterator<Element> kit = kor.iterator();
		while (kit.hasNext()) {
			String a = kit.next().text();
			sentences.add(["",a);
			System.out.println(kit.next().text());
		}

		Elements eng = doc.select(".mar_top01 > input[value]");
		java.util.Iterator<Element> eit = eng.iterator();
		while (eit.hasNext()) {
			System.out.println(eit.next().attr("value"));
		}

	}

}

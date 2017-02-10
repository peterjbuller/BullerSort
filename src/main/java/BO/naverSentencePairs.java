package BO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class naverSentencePairs {
	
	String query = "sport";
	Integer pagenumber = 0;
	ArrayList<String[]> sentences = new ArrayList<String[]>();

	
	@SuppressWarnings("unused")
	private ArrayList<String[]> getPairs() {
		return sentences;
		
	}
	public naverSentencePairs(String query, Integer pageNo) {
		
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

		Elements kor = doc.select("div.fnt_k10 a[class$=detail]");
		Elements eng = doc.select(".mar_top01 > input[value]");
		Iterator<Element> kit = kor.iterator();
		Iterator<Element> eit = eng.iterator();
		while (kit.hasNext()) {
			String k = kit.next().text();
			String e = eit.next().attr("value");
			sentences.add(new String[]{k,e});
		}
		
			
		
	
		
	}

}

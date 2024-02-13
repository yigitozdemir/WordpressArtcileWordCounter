package com.yigitozdemir.counter;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Runner {

	public static void main(String[] args) {
		Runner runner = new Runner();
		String url = args[0];
		 

		try {
			Document document = Jsoup.connect(url).get();
			Elements elements = document.getElementsByTag("article");
			Element article = elements.get(0);
			
			int numbers = runner.countWordsUsingSplit(article.text());
			
			System.out.println("Words including ccode: " + numbers);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int countWordsUsingSplit(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}

		String[] words = input.split("\\s+");
		return words.length;
	}

}

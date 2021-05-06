package newsanalyzer.ctrl;

import newsapi.NewsApi;
import newsapi.beans.Article;
import newsapi.beans.NewsReponse;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {

	public static final String APIKEY = "538d94982e5444b78cfe15198c4786b2";

	public void process(NewsApi stream) throws IOException, NewsApiException {
		System.out.println("Start process");

		//versuchen daten von api zu bekommen getdata
		//exception müssen beim user landen -> im userinterface
		//wir fangen nur runtime exceptions ab , url exc,io exc.

		NewsReponse newsReponse = stream.getNews();


		if(newsReponse != null){
			List<Article> articles = newsReponse.getArticles();
			articles.stream().forEach(article -> System.out.println(article.toString()));

			System.out.println("Number of Articles: "+ getNumberOfArticle(articles));
			System.out.println("Best Provider: " +getBestProvider(articles));
			System.out.println("Shortes name (author):" + getShortestName(articles));
		}else{
			throw new NewsApiException("No News");
		}

		//TODO implement Error handling

		//TODO load the news based on the parameters

		//TODO implement methods for analysis

		System.out.println("End process");
	}

	public List<Article> getTitlesSortedByLenght(List<Article> data){
		return data
				.stream()
				.sorted(Comparator.comparing(Article::getTitle))
				.collect(Collectors.toList());
	}

	public long getNumberOfArticle(List<Article> data){
		return (long) data.size();
	}

	public String getBestProvider(List<Article> data){
		return data
				.stream()
				.collect(Collectors.groupingBy(article -> article.getSource().getName(), Collectors.counting()))
				.entrySet()
				.stream()
				.max(Map.Entry.comparingByValue()).orElseThrow(NoSuchElementException::new).getKey();
	}



	public List<Article> getShortestName(List<Article> data) throws NewsApiException {

		return data
				.stream()
				.filter(article -> Objects.nonNull(article.getAuthor()))
				.sorted(Comparator.comparing(Article::getAuthor))
				.collect(Collectors.toList());
	}

	public Object getData() {
		
		return null;
	}
}

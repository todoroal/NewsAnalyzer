package newsanalyzer.ui;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import newsanalyzer.ctrl.Controller;
import newsanalyzer.ctrl.NewsAnalyzerException;
import newsapi.NewsApi;
import newsapi.NewsApiBuilder;
import newsapi.beans.Article;
import newsapi.beans.NewsReponse;
import newsapi.enums.Category;
import newsapi.enums.Country;
import newsapi.enums.Endpoint;

public class UserInterface 
{

	private Controller ctrl = new Controller();

	public void getDataFromCtrl1(){
		//übergabe an controller,

		NewsApi sports = new NewsApiBuilder()
				.setApiKey(Controller.APIKEY)
				.setQ("Sports")
				.setEndPoint(Endpoint.TOP_HEADLINES)
				.setDomains("com")
				.setSourceCategory(Category.sports)
				.createNewsApi();


		try {
			ctrl.process(sports);//newsApi_entertainment);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NewsAnalyzerException e) {
			e.printStackTrace();
		}

	}

	public void getDataFromCtrl2(){
		NewsApi entertainment = new NewsApiBuilder()
				.setApiKey(Controller.APIKEY)
				.setQ("Entertainment")
				.setEndPoint(Endpoint.TOP_HEADLINES)
				.setDomains("com")
				.setSourceCategory(Category.entertainment)
				.createNewsApi();

		try {
			ctrl.process(entertainment);//newsApi_entertainment);
		}
		  catch(MalformedURLException e){
			System.out.println("URL stimmt nicht!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NewsAnalyzerException e) {
			e.printStackTrace();
		}
	}

	public void getDataFromCtrl3(){
		NewsApi health = new NewsApiBuilder()
				.setApiKey(Controller.APIKEY)
				.setQ("Health")
				.setEndPoint(Endpoint.TOP_HEADLINES)
				.setDomains("com")
				.setSourceCategory(Category.health)
				.createNewsApi();

		try {
			ctrl.process(health);//newsApi_entertainment);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NewsAnalyzerException e) {
			e.printStackTrace();
		}
	}


	
	public void getDataForCustomInput() {
		
	}


	public void start() {
		Menu<Runnable> menu = new Menu<>("User Interfacx");
		menu.setTitel("Wählen Sie aus:");
		menu.insert("a", "Sports", this::getDataFromCtrl1); //Lambda notation
		menu.insert("b", "Entertainment", this::getDataFromCtrl2);
		menu.insert("c", "Health", this::getDataFromCtrl3);
		//menu.insert("d", "Title sorted by length", this::getDataFromCtrl4);
		menu.insert("d", "",this::getDataForCustomInput);
		menu.insert("q", "Quit", null);
		Runnable choice;
		while ((choice = menu.exec()) != null) {
			 choice.run();
		}
		System.out.println("Program finished");
	}


    protected String readLine() {
		String value = "\0";
		BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			value = inReader.readLine();
        } catch (IOException ignored) {
		}
		return value.trim();
	}

	protected Double readDouble(int lowerlimit, int upperlimit) 	{
		Double number = null;
        while (number == null) {
			String str = this.readLine();
			try {
				number = Double.parseDouble(str);
            } catch (NumberFormatException e) {
                number = null;
				System.out.println("Please enter a valid number:");
				continue;
			}
            if (number < lowerlimit) {
				System.out.println("Please enter a higher number:");
                number = null;
            } else if (number > upperlimit) {
				System.out.println("Please enter a lower number:");
                number = null;
			}
		}
		return number;
	}
}

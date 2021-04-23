package newsanalyzer.ui;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import newsanalyzer.ctrl.Controller;
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
		System.out.println("ABC");
/*
		NewsApi newsApi_entertainment = new NewsApiBuilder()
				.setApiKey(Controller.APIKEY)
				.setQ("Technology")
				.setEndPoint(Endpoint.TOP_HEADLINES)
				.setDomains("com")
				.setSourceCategory(Category.entertainment)
				.createNewsApi();
*/
		ctrl.process();//newsApi_entertainment);
	}

	public void getDataFromCtrl2(){
	}

	public void getDataFromCtrl3(){

	}
	
	public void getDataForCustomInput() {
		
	}


	public void start() {
		Menu<Runnable> menu = new Menu<>("User Interfacx");
		menu.setTitel("Wählen Sie aus:");
		menu.insert("a", "Choice ABC", this::getDataFromCtrl1); //Lambda notation
		menu.insert("b", "Choice DEF", this::getDataFromCtrl2);
		menu.insert("c", "Choice 3", this::getDataFromCtrl3);
		menu.insert("d", "Choice User Imput:",this::getDataForCustomInput);
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

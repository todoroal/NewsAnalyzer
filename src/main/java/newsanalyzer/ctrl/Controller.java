package newsanalyzer.ctrl;

public class Controller {

	public static final String APIKEY = "myAPIKey";

	public void process() {
		System.out.println("Start process");

		//versuchen daten von api zu bekommen getdata
		//exception müssen beim user landen -> im userinterface
		//wir fangen nur runtime exceptions ab , url exc,io exc.




		//TODO implement Error handling

		//TODO load the news based on the parameters

		//TODO implement methods for analysis

		System.out.println("End process");
	}
	

	public Object getData() {

		return null;
	}
}

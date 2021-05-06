package newsanalyzer.ctrl;

public class NewsApiException extends Exception{

    public NewsApiException(String message){
        super(message);
        System.out.println("NewsApiException: " +message);
    }

}

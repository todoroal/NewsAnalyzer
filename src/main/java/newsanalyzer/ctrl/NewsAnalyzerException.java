package newsanalyzer.ctrl;

public class NewsAnalyzerException extends Exception{

    public NewsAnalyzerException(String message){
        super(message);
        System.out.println("Exception: " +message);
    }

}

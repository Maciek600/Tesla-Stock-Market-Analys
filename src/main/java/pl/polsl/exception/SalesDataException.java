package pl.polsl.exception;

/**
 * @version 1.5
 * @author Maciej Fajlhauer
 */
/**
 * The SalesDataException class is a custom exception used for handling 
 * errors related to sales data. This class helps provide clear error 
 * messages when something goes wrong, making it easier to understand 
 * the issue and take action.
 */
public class SalesDataException extends Exception{
    public SalesDataException(String message){
        super(message);
    }
    
    public SalesDataException(String message, Throwable cause){
        super(message,cause);
    }
}

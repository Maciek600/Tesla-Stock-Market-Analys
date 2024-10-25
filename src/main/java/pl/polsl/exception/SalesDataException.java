package pl.polsl.exception;

/**
 * @version 1.4
 * @author Maciej Fajlhauer
 */
/**
 * Custom exception for handling errors related to sales data processing.
 */
public class SalesDataException extends Exception{
    public SalesDataException(String message){
        super(message);
    }
    
    public SalesDataException(String message, Throwable cause){
        super(message,cause);
    }
}

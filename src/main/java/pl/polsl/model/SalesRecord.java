package pl.polsl.model;
import java.time.LocalDate;
/**
 * @version 1.5
 * @author Maciej Fajlhauer
 */
/**
 * The SalesRecord class represents a single record of sales data. 
 * It stores important information such as the date of the sale, 
 * the volume of shares sold, and the closing price. This class 
 * provides methods to access and manipulate the sales data, 
 * making it easy to work with individual records in the application.
 */
public class SalesRecord {
    
    /** Date of the sales data. */
    private final LocalDate date;
    
    /** First sales figure. */
    private final double open;
    
    /** Second sales figure. */
    private final double high;
    
    /** Third sales figure. */
    private final double low;
    
    /** Fourth sales figure. */
    private final double close;
    
    /** Fifth sales figure. */
    private final double adjClose;
    
    /** Total sales volume. */
    private final long volume;

    /**
     * Constructor to initialize the sales record.
     *
     * @param date the date of the sales record
     * @param open first sales figure
     * @param high second sales figure
     * @param low third sales figure
     * @param close fourth sales figure
     * @param adjClose fifth sales figure
     * @param volume total sales volume
     */
    public SalesRecord(LocalDate date, double open, double high, double low, double close, double adjClose, long volume) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.adjClose = adjClose;
        this.volume = volume;
    }

    /**
     * Gets the date of the sales record.
     *
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Gets the first sales figure.
     *
     * @return the first sales figure
     */
    public double getOpen() {
        return open;
    }

    /**
     * Gets the second sales figure.
     *
     * @return the second sales figure
     */
    public double getHigh() {
        return high;
    }

    /**
     * Gets the third sales figure.
     *
     * @return the third sales figure
     */
    public double getLow() {
        return low;
    }

    /**
     * Gets the fourth sales figure.
     *
     * @return the fourth sales figure
     */
    public double getClose() {
        return close;
    }

    /**
     * Gets the fifth sales figure.
     *
     * @return the fifth sales figure
     */
    public double getAdjClose() {
        return adjClose;
    }

    /**
     * Gets the total sales volume.
     *
     * @return the total sales volume
     */
    public long getVolume() {
        return volume;
    }

    /**
     * Returns a string representation of the sales record.
     *
     * @return a string describing the sales record
     */
    @Override
    public String toString() {
        return "SalesRecord{" +
                "date=" + date +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", adjClose=" + adjClose +
                ", volume=" + volume +
                '}';
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.model;

import java.time.LocalDate;
/**
 * @version 1.0
 * @author Maciej
 */
/**
 * Class representing a record of sales data from a CSV file.
 */
public class SalesRecord {
    
    /** Date of the sales data. */
    private LocalDate date;
    
    /** First sales figure. */
    private double open;
    
    /** Second sales figure. */
    private double high;
    
    /** Third sales figure. */
    private double low;
    
    /** Fourth sales figure. */
    private double close;
    
    /** Fifth sales figure. */
    private double adjClose;
    
    /** Total sales volume. */
    private long volume;

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

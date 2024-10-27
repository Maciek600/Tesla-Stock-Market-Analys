package pl.polsl.model;
import javax.swing.event.SwingPropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import pl.polsl.exception.SalesDataException;

/**
 * @version 1.5
 * @author Maciej Fajlhauer
 */
/**
 * The Model class manages application data, handling operations like 
 * retrieving, sorting, and filtering sales records.
 * The Model does not know about the View or the Controller; it just provides 
 * a way to access and update the data. It can also notify other parts of the 
 * application when its data changes.
 */
 
public class Model {
    
    /** List of sales records */
    private List<SalesRecord> records;
    
    private final SwingPropertyChangeSupport swingPropChangeFirer;

    /**
     * Constructor initializing property change support.
     */
    public Model() {
        this.swingPropChangeFirer = new SwingPropertyChangeSupport(this);
    }
    
    /**
     * Adds a listener to the model to receive updates on property changes.
     *
     * @param listener the property change listener
     */
    public void addListener(PropertyChangeListener listener) {
        swingPropChangeFirer.addPropertyChangeListener(listener);
    }
    
    /**
     * Sets the list of sales records and notifies listeners of the change.
     *
     * @param records the new list of records
     */
    public void setRecords(List<SalesRecord> records) {
        List<SalesRecord> oldRecords = this.records;
        this.records = records;
        swingPropChangeFirer.firePropertyChange("records", oldRecords, records);
    }

    public List<SalesRecord> getRecords() {
        return records;
    }
    
    /**
     * Finds the sales record with the highest volume from the given list of records.
     * 
     * @param records the list of sales records
     * @return the sales record with the highest volume
     * @throws pl.polsl.exception.SalesDataException
     */
    public SalesRecord getDayWithHighestVolume(List<SalesRecord> records) throws SalesDataException {
        if (records == null || records.isEmpty()) {
            throw new SalesDataException("The list is empty or null");
        }

        SalesRecord maxVolumeRecord = records.get(0);

        // Iterate through the list and find the record with the highest volume
        for (SalesRecord record : records) {
            if (record.getVolume() > maxVolumeRecord.getVolume()) {
                maxVolumeRecord = record;
            }
        }

        return maxVolumeRecord;
    }
    
    
    
     /**
     * Sorts the records by closing price (Close) in ascending order.
     * 
     * @return sorted list of records
     */
    public List<SalesRecord> getRecordsSortedByClose() {
        if (records == null || records.isEmpty()) {
            return Collections.emptyList();
        }

        // Sort by closing price (Close)
        records.sort(Comparator.comparingDouble(SalesRecord::getClose));
        return records;
    }
    
     /**
     * Finds the year with the highest total sales volume.
     *
     * @return the year with the highest sales volume
     * @throws pl.polsl.exception.SalesDataException
     */
    public int getYearWithHighestVolume() throws SalesDataException {
        if (records == null || records.isEmpty()) {
            throw new SalesDataException("No records available.");
        }

        // Map to store total volume for each year
        Map<Integer, Long> yearVolumeMap = new HashMap<>();

        // Iterate through the records and sum up volumes per year
        for (SalesRecord record : records) {
            int year = record.getDate().getYear(); // Extract the year from the date
            long volume = record.getVolume(); // Get the volume for this record

            // Accumulate the volume for this year
           
            yearVolumeMap.merge(year, volume, Long::sum);
        }

        // Find the year with the highest volume
        int yearWithMaxVolume = 0;
        long maxVolume = 0;

        for (Map.Entry<Integer, Long> entry : yearVolumeMap.entrySet()) {
            if (entry.getValue() > maxVolume) {
                yearWithMaxVolume = entry.getKey();
                maxVolume = entry.getValue();
            }
        }

        return yearWithMaxVolume; // Return the year with the highest volume
    }
    
    /**
     * Calculates the Pearson correlation between "Open" price and "Volume" of shares.
     *
     * @return the Pearson correlation coefficient as a double
     * @throws pl.polsl.exception.SalesDataException
     */
    public double calculatePearsonCorrelation() throws SalesDataException {
        if (records == null || records.isEmpty() || records.size()<2) {
            throw new SalesDataException("Not enough data to calculate correlation.");
        }

        double sumOpen = 0, sumVolume = 0;
        double sumOpenSquared = 0, sumVolumeSquared = 0;
        double sumOpenTimesVolume = 0;
        int n = records.size();

        // Loop through records to accumulate sums for Pearson calculation
        for (SalesRecord record : records) {
            double open = record.getOpen();
            double volume = record.getVolume();

            sumOpen += open;
            sumVolume += volume;
            sumOpenSquared += open * open;
            sumVolumeSquared += volume * volume;
            sumOpenTimesVolume += open * volume;
        }

        // Calculate numerator and denominator of the Pearson correlation formula
        double numerator = n * sumOpenTimesVolume - sumOpen * sumVolume;
        double denominator = Math.sqrt((n * sumOpenSquared - sumOpen * sumOpen) * (n * sumVolumeSquared - sumVolume * sumVolume));

        // Return correlation coefficient, handling the case where denominator is zero
        return (denominator != 0) ? numerator / denominator : 0;
    }
     
    
}

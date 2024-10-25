package pl.polsl.controller;

import pl.polsl.model.*;
import pl.polsl.view.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.polsl.exception.SalesDataException;
/**
 * @version 1.4
 * @author Maciej Fajlhauer
 */
/**
 * Controller class responsible for handling business logic, including reading CSV data and interacting with the model and view.
 */
public class Controller implements PropertyChangeListener{

    /** Model object for storing application data. */
    private final Model model;
    
    /** View object for displaying data to the user. */
    private final View view;
    
    /** List storing sales records read from the CSV file. */
    private final List<SalesRecord> records;
    
    /**
     * Constructor to initialize the controller with the model and view.
     *
     * @param model the data model
     * @param view the view for displaying data
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.records = new ArrayList<>();  // Initialize the list of records
    
        // Add the controller as a listener to the model to receive property change events
        this.model.addListener(this);
        setupViewActions();
    }
    
      /**
     * Reads sales data from a CSV file, converts it into objects, and stores it in the records list.
     *
     * @param fileName the path to the CSV file
     */
    public void readCSV(String fileName) throws SalesDataException {
        String line;
        String cvsSplitBy = ",";
        boolean firstLine=true;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

             

            // Read each line from the CSV file
            while ((line = br.readLine()) != null) {
                
                // Pomiń pierwszą linię (nagłówki)
            if (firstLine) {
                firstLine = false;
                continue;
            }
                String[] values = line.split(cvsSplitBy);
                
            // Convert string values to appropriate types
            LocalDate date;
            try {
                date = LocalDate.parse(values[0]); // First value is the date
            } catch (Exception e) {
                throw new SalesDataException("Invalid date format in line: " + line, e);
            }

            double sales1, sales2, sales3, sales4, sales5;
            long volume;
            try {
                sales1 = Double.parseDouble(values[1]);
                sales2 = Double.parseDouble(values[2]);
                sales3 = Double.parseDouble(values[3]);
                sales4 = Double.parseDouble(values[4]);
                sales5 = Double.parseDouble(values[5]);
                volume = Long.parseLong(values[6]);
            } catch (NumberFormatException e) {
                throw new SalesDataException("Invalid number format in line: " + line, e);
            }


                // Create a SalesRecord object and add it to the list
                SalesRecord record = new SalesRecord(date, sales1, sales2, sales3, sales4, sales5, volume);
                records.add(record);
            }
            // Ustaw rekordy w modelu
            model.setRecords(records);

        } catch (IOException e) {
            //e.printStackTrace();
            throw new SalesDataException("Error reading CSV file: " + fileName,e);
        }
    }
    
    /**
     * Sets up button actions in the view to interact with the model.
     */
    
    private void setupViewActions() {
    view.getBtnHighestVolume().addActionListener(e -> {
        try {
            SalesRecord highestVolumeRecord = model.getDayWithHighestVolume(records);
            view.displayHighestVolumeDay(highestVolumeRecord);
        } catch (SalesDataException ex) {
        view.displayErrorMessage("Error calculating day with highest volume: " + ex.getMessage());
        }
    });

    view.getBtnSortByClose().addActionListener(e -> {
        List<SalesRecord> sortedRecords = model.getRecordsSortedByClose();
        view.displaySortedRecords(sortedRecords);
    });

    view.getBtnYearWithHighestVolume().addActionListener(e -> {
        try {
            int year = model.getYearWithHighestVolume();
            view.displayYearWithHighestVolume(year);
        } catch (SalesDataException ex) {
        view.displayErrorMessage("Error calculating year with highest volume: " + ex.getMessage());
        }
    });

    view.getBtnPearsonCorrelation().addActionListener(e -> {
        try {
            double correlation = model.calculatePearsonCorrelation();
            view.displayPearsonCorrelation(correlation);
        } catch (SalesDataException ex) {
        view.displayErrorMessage("Error calculating Pearson correlation: " + ex.getMessage());
        }
    });
}


    /**
     * Handles property change events from the model to update the view as needed.
     *
     * @param evt the property change event
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propName = evt.getPropertyName();

        // Update view based on property change
        if ("sortedRecords".equalsIgnoreCase(propName)) {
            view.displaySortedRecords((List<SalesRecord>) evt.getNewValue());
        } 
        else if ("yearWithHighestVolume".equalsIgnoreCase(propName)) {
            view.displayYearWithHighestVolume((Integer) evt.getNewValue());
        }
        else if ("correlationResult".equalsIgnoreCase(propName)) {
            view.displayPearsonCorrelation((Double) evt.getNewValue());
        }
        
    }
}

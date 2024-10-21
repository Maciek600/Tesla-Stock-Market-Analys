package pl.polsl.controller;

import pl.polsl.model.Model;
import pl.polsl.model.SalesRecord;
import pl.polsl.view.View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class responsible for handling business logic, including reading CSV data and interacting with the model and view.
 */
public class Controller {

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
    }
    
    /**
     * Method to execute the default logic (currently calls the view to display data).
     */
//    public void decide() {
//        view.display();
//    }

    /**
     * Reads sales data from a CSV file, converts it into objects, and stores it in the records list.
     *
     * @param fileName the path to the CSV file
     */
    public void readCSV(String fileName) {
        String line;
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            // Skip the header line
            String headerLine = br.readLine(); 

            // Read each line from the CSV file
            while ((line = br.readLine()) != null) {
                String[] values = line.split(cvsSplitBy);
                
                // Convert string values to appropriate types
                LocalDate date = LocalDate.parse(values[0]); // First value is the date
                double sales1 = Double.parseDouble(values[1]);
                double sales2 = Double.parseDouble(values[2]);
                double sales3 = Double.parseDouble(values[3]);
                double sales4 = Double.parseDouble(values[4]);
                double sales5 = Double.parseDouble(values[5]);
                long volume = Long.parseLong(values[6]);

                // Create a SalesRecord object and add it to the list
                SalesRecord record = new SalesRecord(date, sales1, sales2, sales3, sales4, sales5, volume);
                records.add(record);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays all sales records stored in the records list.
     */
    public void displayRecords() {
        for (SalesRecord record : records) {
            System.out.println(record);
        }
    }
}

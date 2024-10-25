/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.view;
import java.util.List;
import pl.polsl.model.*;
import javax.swing.*;
import java.awt.*;
/**
 * @version 1.4
 * @author Maciej Fajlhauer
 */
public class View {
    private JFrame frame;
    private JPanel buttonPanel;
    private JTextArea resultArea;
    private JButton btnHighestVolume;
    private JButton btnSortByClose;
    private JButton btnYearWithHighestVolume;
    private JButton btnPearsonCorrelation;
    
    /** Reference on model */
    private final Model model;

    /**
     * View construtor.
     * 
     * @param model Reference on model
     */
    public View(Model model) {
        this.model = model;  // Widok przechowuje referencję na model
        prepareGUI();
    }
    
    // Getter methods to access buttons from the controller
    public JButton getBtnHighestVolume() { return btnHighestVolume; }
    public JButton getBtnSortByClose() { return btnSortByClose; }
    public JButton getBtnYearWithHighestVolume() { return btnYearWithHighestVolume; }
    public JButton getBtnPearsonCorrelation() { return btnPearsonCorrelation; }
    
    
    /**
     * Display error message thrown from Controller class
     * 
     * 
     * @param message information about error displayed on app
     */
    public void displayErrorMessage(String message){
        resultArea.setText(message);
    }
    
    /**
     * Updates the result area to display a list of records.
     *
     * @param records list of sales records to display
     */
    public void updateRecords(List<SalesRecord> records) {
        StringBuilder sb = new StringBuilder("Records:\n");
        records.forEach(record -> sb.append(record.toString()).append("\n"));
        resultArea.setText(sb.toString());
    }
    
    /**
     * Displays the sales record with the highest volume.
     *
     * @param record the sales record with the highest volume
     */
     public void displayHighestVolumeDay(SalesRecord record) {
        if (record != null) {
            resultArea.setText("The day with the highest volume is: " + record.getDate() +
                " with a volume of " + record.getVolume() + " shares.");
        } else {
            displayNoRecordsMessage();
        }
    }
    
     
    /**
     * Displays a message when no records are available.
     */
    private void displayNoRecordsMessage() {
        resultArea.setText("No sales records available.");
    }

    
    /**
     * Displays a list of sorted records.
     * 
     * @param sortedRecords list of sorted records
     */
    public void displaySortedRecords(List<SalesRecord> sortedRecords) {
        if (sortedRecords == null || sortedRecords.isEmpty()) {
            displayNoRecordsMessage();
        } else {
            StringBuilder sb = new StringBuilder("Sorted records by closing price:\n");
            for (SalesRecord record : sortedRecords) {
                sb.append(record.getDate()).append(": ").append(record.getClose()).append("\n");
            }
            resultArea.setText(sb.toString());
        }
    }

     /**
     * Displays the year with the highest sales volume.
     *
     * @param year the year with the highest volume
     */
    public void displayYearWithHighestVolume(int year) {
        resultArea.setText("The year with the highest sales volume is: " + year);    }
    
    /**
     * Displays Pearson's correlation coefficient.
     * 
     * @param correlation Pearson correlation coefficient
     */
    public void displayPearsonCorrelation(double correlation) {
        resultArea.setText("The Pearson correlation between Open price and Volume is: " + correlation);
    }

    /**
     * Prepares the GUI elements, setting up the frame, buttons, and result area.
     */
    private void prepareGUI() {
        frame = new JFrame("Sales Data Analysis");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel to hold action buttons
        buttonPanel = new JPanel(new GridLayout(1, 4));

        // Initialize buttons
        btnHighestVolume = new JButton("Day with Highest Volume");
        btnSortByClose = new JButton("Sort by Closing Price");
        btnYearWithHighestVolume = new JButton("Year with Highest Volume");
        btnPearsonCorrelation = new JButton("Pearson Correlation");

        // Add buttons to panel
        buttonPanel.add(btnHighestVolume);
        buttonPanel.add(btnSortByClose);
        buttonPanel.add(btnYearWithHighestVolume);
        buttonPanel.add(btnPearsonCorrelation);

        // Result area with scrollable functionality
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Add components to frame
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}

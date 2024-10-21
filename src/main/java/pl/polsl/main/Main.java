package pl.polsl.main;

import pl.polsl.controller.Controller;
import pl.polsl.model.Model;
import pl.polsl.view.View;

/**
 * Main class responsible for starting the application.
 */
public class Main {

    /**
     * Main method that starts the application, processes command-line arguments, and initiates the controller logic.
     *
     * @param args command-line arguments where the CSV file should be specified with the -i flag
     */
    public static void main(String[] args) {

        // Check if the arguments contain the -i flag and the file name
        String fileName = null;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-i") && i + 1 < args.length) {
                fileName = args[i + 1];  // Retrieve the file name
            }
        }

        // If no file is provided, print an error message and exit
        if (fileName == null) {
            System.out.println("No CSV file provided after the -i flag.");
            return;
        }

        // Initialize the model, view, and controller
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);

        // Call the decide method (default logic)
//        controller.decide();

        // Read data from the CSV file
        controller.readCSV(fileName);

        // Display the records after reading
        controller.displayRecords();
    }
}

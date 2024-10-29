# Stock Data Analysis Application

This Java application is designed for analyzing stock sales data, providing insights such as the day with the highest trading volume and displaying records sorted by closing price. The application follows the Model-View-Controller (MVC) pattern, ensuring a clear separation between data management, user interaction, and data display.

# Features
- **Day with Highest Volume**: Finds the sales record with the highest volume from the given list of records.
- **Sorting by Closing Price**: Sorts the records by closing price (Close) in ascending order.
- **Year With Highest Volume**: Finds the year with the highest total sales volume.
- **Calculate Pearson Correlation**: Calculates the Pearson correlation between "Open" price and "Volume" of shares.
- **Custom Exceptions**: Handles file reading and data parsing issues with custom error messages, improving reliability and user feedback.
- **File Input**: Reads the stock data file specified by the user as a command-line argument.

# Project Structure
The application is organized into three main packages to support MVC principles:

## **Model**: This package contains the data model classes for the application.
 It includes:
 -'Model' which manages the application data and logic,
 -'SalesRecord' which represents individual sales records containing relevant information such as date, volume, and closing price.
  The model is independent of the view and controller, ensuring a clear separation of concerns in accordance with the MVC pattern.
  
## **View**: This package handles the user interface of the application.
- It is responsible for displaying information to the user and receiving user inputs. The view updates in response to changes in the model and interacts with the controller to reflect the current state of the application.
  
## **Controller**: This package contains the controller classes for the application. It manages the flow of data between the 'model' and 'view'.
  The controller processes user inputs, interacts with the model to perform operations, and requests updates from the view as needed. It also handles exceptions that may arise during data processing.

# Usage
1. Compile the application:
   javac Main.java -i path/to/your/stockdata.csv

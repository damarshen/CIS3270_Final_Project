package GUI_Design;

import Objects.Flights.Flight;
import javafx.application.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

public  class FlightRegistration  extends Application implements EventHandler<ActionEvent>{


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Search");
		AnchorPane anchor = new AnchorPane();
		anchor.setPadding(new Insets(20, 20, 20, 20));
		
		Text airline = new Text("Airline");
		airline.setLayoutX(200);
		airline.setLayoutY(45);
		
		Text flightNumber = new Text("Flight Number");
		flightNumber.setLayoutX(200);
		flightNumber.setLayoutY(80);
		
		Text originCity = new Text("Origin City");
		originCity.setLayoutX(200);
		originCity.setLayoutY(115);
		
		Text destinationCity = new Text ("Destination City");
		destinationCity.setLayoutX(200);
		destinationCity.setLayoutY(150);
		
		Text departureDate = new Text("Departure Date");
		departureDate.setLayoutX(200);
		departureDate.setLayoutY(185);
		
		Text departureTime = new Text("Departure Time");
		departureTime.setLayoutX(200);
		departureTime.setLayoutY(220);
		
		Text arrivalDate = new Text("Arrival Date");
		arrivalDate.setLayoutX(200);
		arrivalDate.setLayoutY(255);
		
		Text arrivalTime = new Text("Arrival Time");
		arrivalTime.setLayoutX(200);
		arrivalTime.setLayoutY(290);
		
		Text capacity = new Text("Capacity");
		capacity.setLayoutX(200);
		capacity.setLayoutY(330);
		
		Text seatsAvailable = new Text("Seats Available");
		seatsAvailable.setLayoutX(200);
		seatsAvailable.setLayoutY(365);
		
		
		
		TextField airlineTxtField = new TextField();
		airlineTxtField.setLayoutX(300);
		airlineTxtField.setLayoutY(25);
		airlineTxtField.setPromptText("Airline");
		
		
		TextField flightNumberTxtField = new TextField();
		flightNumberTxtField.setLayoutX(300);
		flightNumberTxtField.setLayoutY(60);
		flightNumberTxtField.setPromptText("Flight Number");
		
		TextField originCityTxtField = new TextField();
		originCityTxtField.setLayoutX(300);
		originCityTxtField.setLayoutY(95);
		originCityTxtField.setPromptText("Origin City");
		
		
		TextField destinationCityTxtField = new TextField ();
		destinationCityTxtField.setLayoutX(300);
		destinationCityTxtField.setLayoutY(130);
		destinationCityTxtField.setPromptText("Destination City");
		
		TextField departureDateTxtField = new TextField();
		departureDateTxtField.setLayoutX(300);
		departureDateTxtField.setLayoutY(165);
		departureDateTxtField.setPromptText("YYYY-MM-DD");
		
		TextField departureTimeTxtField = new TextField();
		departureTimeTxtField.setLayoutX(300);
		departureTimeTxtField.setLayoutY(200);
		departureTimeTxtField.setPromptText("HH:MM:SS");
		
		TextField arrivalDateTxtField = new TextField();
		arrivalDateTxtField.setLayoutX(300);
		arrivalDateTxtField.setLayoutY(235);
		arrivalDateTxtField.setPromptText("YYYY-MM-DD");
		
		
		TextField arrivalTimeTxtField = new TextField();
		arrivalTimeTxtField.setLayoutX(300);
		arrivalTimeTxtField.setLayoutY(270);
		arrivalTimeTxtField.setPromptText("HH:MM:SS");
		
		TextField capacityTxtField = new TextField();
		capacityTxtField.setLayoutX(300);
		capacityTxtField.setLayoutY(310);
		capacityTxtField.setPromptText("Capacity");
		
		TextField seatsAvailableTxtField = new TextField();
		seatsAvailableTxtField.setLayoutX(300);
		seatsAvailableTxtField.setLayoutY(345);
		seatsAvailableTxtField.setPromptText("Seats Available");
		
		
		
		
		anchor.getChildren().addAll(airline, flightNumber, originCity, destinationCity,departureDate, departureTime,
									arrivalDate, arrivalTime,capacity,seatsAvailable, airlineTxtField,flightNumberTxtField,originCityTxtField,
									destinationCityTxtField,departureDateTxtField, departureTimeTxtField,arrivalDateTxtField,arrivalTimeTxtField, 
									capacityTxtField,seatsAvailableTxtField);
		Scene scene = new Scene(anchor, 1300, 700);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		primaryStage.setMaximized(false);
		primaryStage.centerOnScreen();
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

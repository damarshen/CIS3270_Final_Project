package GUI_Design;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

import Objects.Flights.Flight;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author ojall
 *
 */

public class searchPage extends Application implements EventHandler<ActionEvent> {
	private ObservableList<ObservableList> data;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Search");
		primaryStage.setResizable(false);
		AnchorPane anchor = new AnchorPane();
		anchor.setPadding(new Insets(20, 20, 20, 20));
		
		TableView<Flight> table = new TableView<>();
		final ObservableList<Flight> data = FXCollections.observableArrayList();

		ChoiceBox<String> dropdown = new ChoiceBox<>();
		dropdown.getItems().addAll("Destnation", "Origin", "Date", "Departure Time", "Airline");
		dropdown.setValue("Destnation");
		dropdown.setLayoutY(60);
		dropdown.setLayoutX(340);

		Label userId = new Label();
		userId.setAlignment(javafx.geometry.Pos.CENTER);
		userId.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
		userId.setLayoutX(1000.0);
		userId.setLayoutY(10.0);
		userId.setText("Logged in as: " + Login.user);
		userId.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
		userId.setFont(new Font(18.0));

		TextField searchTxt = new TextField();
		searchTxt.setLayoutX(460.0);
		searchTxt.setLayoutY(60.0);
		searchTxt.setMinWidth(250);

		Button searchButton = new Button("Search");
		searchButton.setLayoutX(715);
		searchButton.setLayoutY(60.0);
		searchButton.setMinWidth(60);
		searchButton.setOnAction(e -> {
			System.out.println();
			try {

				String dbSearch = getChoice(dropdown).trim();
				String searchItem = searchTxt.getText().trim();
				Connection myConn = DriverManager.getConnection(
						"jdbc:mysql://35.193.248.221:3306/?verifyServerCertificate=false&useSSL=true", "root",
						"Tdgiheay12");
				String sqlUserCheck = "SELECT * FROM flights.flight WHERE " + dbSearch + " = '" + searchItem + "'";
				// create a statement
				PreparedStatement myStat = myConn.prepareStatement(sqlUserCheck);
				// execute a query
				ResultSet myRs;
				myRs = myStat.executeQuery();
				table.getItems().clear();

				// Creates a variable for future checking
				int count = 0;

				while (myRs.next()) {

					count += 1;

					data.add(new Flight(
							myRs.getInt("number"),
							myRs.getString("airline"),
							myRs.getString("origin_city"),
							myRs.getString("destination_city"),
							myRs.getString("departure_date"),
							myRs.getTime("departure_time"),
							myRs.getString("arrival_date"),
							myRs.getTime("arrival_time"),
							myRs.getInt("seats_available")));
					table.setItems(data);
				}
				myStat.close();
				myRs.close();
;			} catch (Exception ex) {

			}
		});

		
		
		TableColumn<Flight, Integer> column1 = new TableColumn<Flight, Integer>("Flight Number");
		column1.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
		column1.setMinWidth(128.88);
		
		TableColumn<Flight, String> column2 = new TableColumn<Flight, String>("Airline");
		column2.setCellValueFactory(new PropertyValueFactory<>("Airline"));
		column2.setMinWidth(128.88);

		TableColumn<Flight, String> column3 = new TableColumn<Flight, String>("Origin City");
		column3.setCellValueFactory(new PropertyValueFactory<>("originCity"));
		column3.setMinWidth(128.88);
		
		TableColumn<Flight, String> column4 = new TableColumn<Flight, String>("Destination City");
		column4.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));
		column4.setMinWidth(128.88);
		
		TableColumn<Flight, Date> column5 = new TableColumn<Flight, Date>("Departure Date");
		column5.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
		column5.setMinWidth(128.88);
		
		TableColumn<Flight, Time> column6 = new TableColumn<Flight, Time>("Departure Time");
		column6.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
		column6.setMinWidth(128.88);
		
		TableColumn<Flight, Date> column7 = new TableColumn<Flight, Date>("Arrival Date");
		column7.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));
		column7.setMinWidth(128.88);
		
		TableColumn<Flight, Time> column8 = new TableColumn<Flight, Time>("Arrival Time");
		column8.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
		column8.setMinWidth(128.88);
		
		TableColumn<Flight, Integer> column9 = new TableColumn<Flight, Integer>("Seats Available");
		column9.setCellValueFactory(new PropertyValueFactory<>("seatsAvailable"));
		column9.setMinWidth(128.88);
		
		table.setTableMenuButtonVisible(true);
		
		table.setLayoutY(100);
		table.setLayoutX(20);
		table.setMinWidth(1160);
		table.setMinHeight(580);
		table.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9);
		anchor.getChildren().addAll(dropdown, userId, searchTxt, searchButton, table);
		Scene scene = new Scene(anchor, 1200, 700);

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public String getChoice(ChoiceBox<String> dropdown) {

		String dbSearch = "";
		String choice = dropdown.getValue();

		if (choice.equals("Destnation")) {
			dbSearch = "destination_city";
		}

		else if (choice.equals("Origin")) {
			dbSearch = "origin_city";
		} else if (choice.equals("Date")) {
			dbSearch = "departure_date";
		} else if (choice.equals("Departure Time")) {
			dbSearch = "departure_time";
		} else if (choice.equals("Airline")) {
			dbSearch = "airline";
		}
		return dbSearch;

	}
	

}

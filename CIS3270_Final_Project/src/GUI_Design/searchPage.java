package GUI_Design;

import java.sql.*;

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

/**
 * @author ojall
 *
 */

public class searchPage extends Application implements EventHandler<ActionEvent> {
	private ObservableList<ObservableList> data;
	private String usernameId = "";

	public String getUsernameId() {
		return usernameId;
	}

	public void setUsernameId(String usernameId) {
		this.usernameId = usernameId;
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Search");
		primaryStage.setResizable(true);
		primaryStage.setMaximized(true);
		AnchorPane anchor = new AnchorPane();
		anchor.setPadding(new Insets(20, 20, 20, 20));
		TableView<Flight> table = new TableView<>();
		final ObservableList<Flight> data = FXCollections.observableArrayList();

		ChoiceBox<String> dropdown = new ChoiceBox<>();
		dropdown.getItems().addAll("Destnation", "Origin", "Departure", "Airline");
		dropdown.setValue("Destnation");
		dropdown.setLayoutY(60);
		dropdown.setLayoutX(340);

		Button returnHome = new Button("Return Home");
		returnHome.setOnAction(e -> {
			mainPage home = new mainPage();
			try {
				home.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		returnHome.setLayoutX(970);
		returnHome.setLayoutY(60);
		returnHome.setMinWidth(100);

		Button logOut = new Button("Log Out");
		logOut.setOnAction(e -> {
			Login loginPage = new Login();
			try {
				loginPage.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		logOut.setLayoutX(1080);
		logOut.setLayoutY(60);
		logOut.setMinWidth(100);

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

		TextField addFlight = new TextField();
		addFlight.setLayoutX(1200);
		addFlight.setLayoutY(300);

		Label addFlightLbl = new Label("Select Flight Number to Add");
		try {
			Connection myConn;
			myConn = DriverManager.getConnection(
					"jdbc:mysql://35.193.248.221:3306/?verifyServerCertificate=false&useSSL=true", "root",
					"Tdgiheay12");

			String sqlUserCheck = "SELECT * FROM `flights`.`users` where username = '" + Login.user + "'";
			// create a statement
			Statement myStat = myConn.createStatement();
			// execute a query
			ResultSet myRs;
			myRs = myStat.executeQuery(sqlUserCheck);

			// Creates a variable for future checking
			int count = 0;
			while (myRs.next()) {
				count = count + 1;
				setUsernameId(myRs.getString("id"));
				System.out.println(getUsernameId());

			}

		} catch (Exception exc) {

		}

		addFlightLbl.setLayoutX(1200);
		addFlightLbl.setLayoutY(275);

		Button addFlightBtn = new Button("Add Flight");
		addFlightBtn.setLayoutX(1240);
		addFlightBtn.setLayoutY(335);
		addFlightBtn.setOnAction(e -> {
			try {

				Connection myConn;
				myConn = DriverManager.getConnection(
						"jdbc:mysql://35.193.248.221:3306/?verifyServerCertificate=false&useSSL=true", "root",
						"Tdgiheay12");

				String sqlFlightBook = "INSERT INTO `flights`.`Flight_User`(`Flight_id`,`User_id`)VALUES("+ addFlight.getText().trim() + ", " + getUsernameId() + ")";
				String sqlFlightCheck= "SELECT `Flight_id`, `User_id` FROM `flights`.`Flight_User` where User_id = '"+ getUsernameId() + "' and Flight_id= '"+ addFlight.getText().trim()+"'";
				// create a statement
				Statement myStat = myConn.createStatement();
				// execute a query
				ResultSet myRs;
				myRs = myStat.executeQuery(sqlFlightCheck);

				// Creates a variable for future checking
				int count = 0;
				while (myRs.next()) {
					count = count + 1;

				}
				
				if(count == 0) {
					myStat.executeUpdate(sqlFlightBook);
				}
				
				else {
					AlertBox.display("Error!", "Error! you have alredy booked flight number: "+ addFlight.getText().trim() +". \n You cannot Book the same flight tiwce!" );
				}
				myStat.close();
				myRs.close();
				myConn.close();
			}

			catch (SQLException e1) {
				System.out.println(e1.getMessage());
				
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
		
		TableColumn<Flight, Date> column7 = new TableColumn<Flight, Date>("Arrival date");
		column7.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
		column7.setMinWidth(128.88);

		TableColumn<Flight, Time> column8 = new TableColumn<Flight, Time>("Arrival Time");
		column8.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
		column8.setMinWidth(128.88);

		TableColumn<Flight, Integer> column9 = new TableColumn<Flight, Integer>("Seats Available");
		column9.setCellValueFactory(new PropertyValueFactory<>("seatsAvailable"));
		column9.setMinWidth(128.88);

		table.setTableMenuButtonVisible(false);

		Button searchButton = new Button("Search");
		searchButton.setLayoutX(715);
		searchButton.setLayoutY(60.0);
		searchButton.setMinWidth(60);
		searchButton.setOnAction(e -> {
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
				
				while (myRs.next()) {

					
					data.add(new Flight(myRs.getInt("number"), myRs.getString("airline"), myRs.getString("origin_city"),
							myRs.getString("destination_city"), myRs.getDate("departure_date"), myRs.getTime("departure_time"),myRs.getDate("arrival_date"),
							myRs.getTime("arrival_time"),myRs.getInt("seats_available")));
					table.setItems(data);
				}
				myStat.close();
				myRs.close();
				myConn.close();
				
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		});


		table.setLayoutY(100);
		table.setLayoutX(20);
		table.setMinWidth(1160);
		table.setMinHeight(580);
		table.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9);
		anchor.getChildren().addAll(dropdown, userId, searchTxt, searchButton, table, returnHome, logOut, addFlight,
				addFlightLbl, addFlightBtn);
		Scene scene = new Scene(anchor, 1300, 700);

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
		}
		 else if (choice.equals("Airline")) {
			dbSearch = "airline";
		}
		return dbSearch;

	}

}

package GUI_Design;

import java.sql.*;

import Objects.Flights.Flight;
import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class mainPage extends Application implements EventHandler<ActionEvent> {

	private ObservableList<ObservableList> data;
	
	public static void main(String[] args) {
		launch(args);
	}
	
		
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Home");
		primaryStage.setResizable(false);
		AnchorPane anchor = new AnchorPane();
		anchor.setPadding(new Insets(10,10,10,10));
		
		TableView<Flight> table = new TableView<>();
		final ObservableList<Flight> data = FXCollections.observableArrayList();
		
		Label userId = new Label();
		Button searchFlights = new Button();
        Label myFlights = new Label();
        Button deleteFlights = new Button();
        Button logOut = new Button();

      
		userId.setAlignment(javafx.geometry.Pos.CENTER);
		userId.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
		userId.setLayoutX(970.0);
		userId.setLayoutY(20.0);
		userId.setText("Logged in as: " + Login.user);
		userId.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
		userId.setFont(new Font(18.0));

        searchFlights.setLayoutX(1057.0);
        searchFlights.setLayoutY(99.0);
        searchFlights.setMnemonicParsing(false);
        searchFlights.setText("Search Flights");
        searchFlights.setOnAction(e ->{
        	searchPage search = new searchPage();
        	try {
				search.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        });

        table.setLayoutX(10.0);
        table.setLayoutY(57.0);
        table.setPrefHeight(329.0);
        table.setPrefWidth(1031.11);

        myFlights.setLayoutX(420.0);
        myFlights.setLayoutY(10.0);
        myFlights.setText("My Flights");
        myFlights.setFont(new Font(25.0));
        
        logOut.setLayoutX(1057.0);
        logOut.setLayoutY(239.0);
        logOut.setMnemonicParsing(false);
        logOut.setPrefHeight(25);
        logOut.setPrefWidth(90);
        logOut.setText("Log Out");
        logOut.setOnAction(e ->{
        	Login loginPage = new Login();
        	try {
				loginPage.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        });
        

        deleteFlights.setLayoutX(1057.0);
        deleteFlights.setLayoutY(169.0);
        deleteFlights.setMnemonicParsing(false);
        deleteFlights.setPrefHeight(25.0);
        deleteFlights.setPrefWidth(90.0);
        deleteFlights.setText("Delete Flight");
        
        
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
		
		table.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8);
		
		try {

			Connection myConn = DriverManager.getConnection(
					"jdbc:mysql://35.193.248.221:3306/?verifyServerCertificate=false&useSSL=true", "root",
					"Tdgiheay12");
			String sqlUserCheck = "select  `number`, `airline`, `origin_city`, `destination_city`, `departure_time`, `arrival_time`, `departure_date`, `arrival_date` from\r\n" + 
					"flights.flight inner Join flights.Flight_User\r\n" + 
					"on Flight_id = flight.id\r\n" + 
					"inner join flights.users on Flight_User.User_id = users.id where username = '"+ Login.user + "'";
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
						myRs.getTime("arrival_time")));
				table.setItems(data);
			}
			myStat.close();
			myRs.close();
;			} catch (Exception ex) {

		}

        anchor.getChildren().add(userId);
        anchor.getChildren().add(searchFlights);
        anchor.getChildren().add(table);
        anchor.getChildren().add(myFlights);
        anchor.getChildren().add(deleteFlights);
        anchor.getChildren().add(logOut);
		
		
		
		Scene scene =new Scene(anchor, 1150, 500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}

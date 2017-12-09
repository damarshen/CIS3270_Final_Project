package GUI_Design;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Objects.Flights.Flight;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author ojall
 *
 */

public class searchPage extends Application implements EventHandler<ActionEvent> {
	private ObservableList<ObservableList> data;
	private TableView tableview;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Search");
		primaryStage.setResizable(false);
		AnchorPane anchor = new AnchorPane();
		anchor.setPadding(new Insets(20, 20, 20, 20));

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
				// create a statement
				Statement myStat = myConn.createStatement();
				// execute a query
				ResultSet myRs;

				String sqlUserCheck = "SELECT * FROM `flights`.`flight` WHERE " + dbSearch + " = '" + searchItem + "'";
				myRs = myStat.executeQuery(sqlUserCheck);

				// Creates a variable for future checking
				int count = 0;

				while (myRs.next()) {

					count += 1;

					System.out.println(myRs.getString("airline"));

				}

			} catch (Exception ex) {

			}
		});

		TableView<Flight> table = new TableView<>();
		table.setLayoutY(100);
		table.setLayoutX(20);
		table.setMinWidth(1160);
		table.setMinHeight(580);

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

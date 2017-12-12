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

public class test extends Application implements EventHandler<ActionEvent> {
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Search");
		primaryStage.setResizable(true);
		primaryStage.setMaximized(true);
		AnchorPane anchor = new AnchorPane();
		anchor.setPadding(new Insets(20, 20, 20, 20));
		
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

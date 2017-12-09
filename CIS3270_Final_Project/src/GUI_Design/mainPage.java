package GUI_Design;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class mainPage extends Application implements EventHandler<ActionEvent> {

	public static void main(String[] args) {
		launch(args);
	}
	
		
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("");
		primaryStage.setResizable(false);
		AnchorPane anchor = new AnchorPane();
		anchor.setPadding(new Insets(10,10,10,10));
		
		Label userId = new Label();
		Button searchFlights = new Button();
        TableView table = new TableView();
        Label myFlights = new Label();
        Button deleteFlights = new Button();
        Button logOut = new Button();

      
		userId.setAlignment(javafx.geometry.Pos.CENTER);
		userId.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
		userId.setLayoutX(350.0);
		userId.setLayoutY(10.0);
		userId.setText("Logged in as: " + Login.user);
		userId.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
		userId.setFont(new Font(18.0));

        searchFlights.setLayoutX(417.0);
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
        table.setPrefWidth(377.0);

        myFlights.setLayoutX(125.0);
        myFlights.setLayoutY(10.0);
        myFlights.setText("My Flights");
        myFlights.setFont(new Font(25.0));
        
        logOut.setLayoutX(417.0);
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
        

        deleteFlights.setLayoutX(417.0);
        deleteFlights.setLayoutY(169.0);
        deleteFlights.setMnemonicParsing(false);
        deleteFlights.setPrefHeight(25.0);
        deleteFlights.setPrefWidth(90.0);
        deleteFlights.setText("Delete Flight");

        anchor.getChildren().add(userId);
        anchor.getChildren().add(searchFlights);
        anchor.getChildren().add(table);
        anchor.getChildren().add(myFlights);
        anchor.getChildren().add(deleteFlights);
        anchor.getChildren().add(logOut);
		
		
		
		Scene scene =new Scene(anchor, 565, 387);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}

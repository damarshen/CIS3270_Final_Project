package JDBC;
import javax.swing.JOptionPane;

import GUI_Design.AlertBox;
import java.sql.*;
import GUI_Design.mainPage;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;

public class preparedStatments extends Application implements EventHandler<ActionEvent> {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		launch(args);
		
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Recover Password");
		primaryStage.setResizable(false);
		GridPane grid = new GridPane();
		//grid.setGridLinesVisible(true);
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(10);
		grid.setHgap(10);
		
		Label passwordRecoverLabel =new Label("Recover Your Password");
		grid.setConstraints(passwordRecoverLabel , 1, 0);
		grid.setAlignment(Pos.TOP_CENTER);
		passwordRecoverLabel.setTextAlignment(TextAlignment.CENTER);
		
		Text usernameLabel =new Text("Enter Your Username Below");
		grid.setConstraints(usernameLabel , 1, 1);
		grid.setAlignment(Pos.TOP_CENTER);
		usernameLabel.setTextAlignment(TextAlignment.CENTER);
		
		TextField username =new TextField();
		grid.setConstraints(username , 1, 2);
		grid.setAlignment(Pos.CENTER);
		
		Button recover = new Button("Recover Password");
		grid.setConstraints(recover,1,4);
		
		Button login = new Button("Return To Log In");
		grid.setConstraints(login, 1,5);
		
		login.setMinWidth(150);
		recover.setMinWidth(150);
		
		Scene scene =new Scene(grid, 320, 350);
		
		
		
		grid.getChildren().addAll(passwordRecoverLabel, usernameLabel, username, recover, login);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	
	

}

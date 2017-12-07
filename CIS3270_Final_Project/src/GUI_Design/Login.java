package GUI_Design;
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
import javafx.stage.*;

public class Login extends Application implements EventHandler<ActionEvent> {
	public static String user="";
	public static String password = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		launch(args);
		
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Log In");
		primaryStage.setResizable(false);
		GridPane grid = new GridPane();
		//grid.setGridLinesVisible(true);
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(10);
		grid.setHgap(10);
		
		
		Label loginLabel =new Label("Enter your username and password");
		grid.setConstraints(loginLabel, 1, 0);
		grid.setAlignment(Pos.TOP_CENTER);
		
		Label usernameLabel = new Label("Username:");
		grid.setConstraints(usernameLabel, 0, 1);
		
		TextField userTxt = new TextField();
		grid.setConstraints(userTxt, 1, 1);
		
		Label passwordLabel = new Label("Password:");
		grid.setConstraints(passwordLabel, 0, 2);
		
		PasswordField passwordTxt = new PasswordField();
		passwordTxt.setOnAction(e ->{//Exception handling for connecting to the database
			try {
				//get a connection to the database
				Connection myConn = DriverManager.getConnection("jdbc:mysql://35.193.248.221:3306/?verifyServerCertificate=false&useSSL=true", "root", "Tdgiheay12");
				//create a statement
				Statement myStat = myConn.createStatement();
				//execute a query
				ResultSet myRs;	
					
				//collects user name from the user name text field and assigns to a string called user
				user = userTxt.getText().trim();
				
				//Collects password from the password text field and assigns to a string called password
				String password = passwordTxt.getText().trim();
				
				//SQL query to check if user  name and password is in database
				String sqlUserCheck = "SELECT `username` FROM `flights`.`user` where username = '" + user + "' and password = '" + password + "'";
				myRs = myStat.executeQuery(sqlUserCheck);
				
				//Creates a variable for future checking
				int count = 0;
				
				//While loop that will determine if user is in the database
				while(myRs.next()){
					
					count = count + 1;
					
					}
				
				//If user is in the database and the password is correct it it will take user to main page
				if (count==1) {
				
					
				}
				
				/**If user is not in database or password is incorrect, an error message is displayed prompting 
				 *  change in user name or password, attempt password recovery, 
				 *  or prompts the user to register if they do not have an account
				**/
				else if (count<1) {
					AlertBox.display("Incorrect Log In", "Username and password combination is either incorrect or the account does not exist.\n Please select The forgot password if your password is unknonwn, or the register option to create an account.");
				}
				
				}
			
				catch(Exception ex){
					
				}
			
			
		});
		
		
		grid.setConstraints(passwordTxt, 1, 2);
		
		
		//login button and event handler
		Button login =new Button("Log In");
		login.setOnAction(e -> {

			
			//Exception handling for connecting to the database
			try {
			//get a connection to the database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://35.193.248.221:3306/?verifyServerCertificate=false&useSSL=true", "root", "Tdgiheay12");
			//create a statement
			Statement myStat = myConn.createStatement();
			//execute a query
			ResultSet myRs;	
				
			//collects user name from the user name text field and assigns to a string called user
			user = userTxt.getText().trim();
			
			//Collects password from the password text field and assigns to a string called password
			String password = passwordTxt.getText().trim();
			
			//SQL query to check if user  name and password is in database
			String sqlUserCheck = "SELECT `username` FROM `flights`.`user` where username = '" + user + "' and password = '" + password + "'";
			myRs = myStat.executeQuery(sqlUserCheck);
			
			//Creates a variable for future checking
			int count = 0;
			
			//While loop that will determine if user is in the database
			while(myRs.next()){
				
				count = count + 1;
				
				}
			
			//If user is in the database and the password is correct it it will take user to main page
			if (count==1) {
			
				
			}
			
			/**If user is not in database or password is incorrect, an error message is displayed prompting 
			 *  change in user name or password, attempt password recovery, 
			 *  or prompts the user to register if they do not have an account
			**/
			else if (count<1) {
				AlertBox.display("Incorrect Log In", "Username and password combination is either incorrect or the account does not exist.\n Please select The 'Forgot Password' option if your password is unknonwn, \n or the register option to create an account.");
			}
			
			}
		
			catch(Exception ex){
				
			};
			}
		);
		grid.setConstraints(login, 1, 3);
		grid.setHalignment(login, HPos.CENTER);
		
		Button register = new Button("Register");
		grid.setConstraints(register, 1, 4);
		grid.setHalignment(register, HPos.CENTER);
		
		Button passwordRecover = new Button("Forgot Password");
		grid.setConstraints(passwordRecover, 1, 5);
		grid.setHalignment(passwordRecover, HPos.CENTER);
		
		Button exit =new Button("Exit");
		grid.setConstraints(exit, 1, 6);
		grid.setHalignment(exit, HPos.CENTER);
		exit.setOnAction(e ->{
			AlertBox.display("Exit", "System Will Now Exit.");
		System.exit(0);});
		
		exit.setMinWidth(150);
		register.setMinWidth(150);
		passwordRecover.setMinWidth(150);
		login.setMinWidth(150);
		
		
		grid.getChildren().addAll(userTxt, passwordTxt, login, register,passwordRecover, usernameLabel, exit, loginLabel,passwordLabel);
		Scene scene =new Scene(grid, 320, 250);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	
	

}
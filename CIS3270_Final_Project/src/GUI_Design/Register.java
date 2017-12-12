package GUI_Design;

import java.sql.*;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class Register extends Application implements EventHandler<ActionEvent>{


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	

	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {



		

		addLabel("lFullName", "First/Last Name", 230, 70, 154, 20);
		addLabel("lrequired", "*", 380, 70, 154, 20);
		addLabel("lrequired", "*", 495, 70, 154, 20);

		tfName = new JTextField();
		tfName.setBounds(390, 70, 105, 25);
		frame.getContentPane().add(tfName);
		tfName.setColumns(10);

		tlName = new JTextField();
		tlName.setBounds(505, 70, 105, 25);
		frame.getContentPane().add(tlName);
		tlName.setColumns(10);

		addLabel("Address", "Address", 230, 120, 154, 20);

		tAddress = new JTextField();
		tAddress.setBounds(390, 120, 220, 25);
		frame.getContentPane().add(tAddress);
		tAddress.setColumns(10);

		addLabel("lAddress2", "City, State Zip", 230, 150, 154, 20);

		tCity = new JTextField();
		tCity.setBounds(390, 150, 100, 25);
		frame.getContentPane().add(tCity);
		tCity.setColumns(10);

		tState = new JTextField();
		tState.setBounds(500, 150, 50, 25);
		frame.getContentPane().add(tState);
		tState.setColumns(10);

		tZip = new JTextField();
		tZip.setBounds(560, 150, 50, 25);
		frame.getContentPane().add(tZip);
		tZip.setColumns(10);

		addLabel("lUsername", "User Name", 230, 200, 154, 20);
		addLabel("lrequired", "*", 380, 200, 154, 20);

		tUserName = new JTextField();
		tUserName.setBounds(390, 200, 220, 25);
		frame.getContentPane().add(tUserName);
		tUserName.setColumns(10);

		addLabel("lPassword", "Password", 230, 230, 154, 20);
		addLabel("lrequired", "*", 380, 230, 154, 20);

		tPassword = new JPasswordField();
		tPassword.setBounds(390, 230, 220, 25);
		frame.getContentPane().add(tPassword);
		tPassword.setColumns(10);

		addLabel("lConfirm", "Confirm", 230, 260, 154, 20);
		addLabel("lrequired", "*", 380, 260, 154, 20);

		tConfirm = new JPasswordField();
		tConfirm.setBounds(390, 260, 220, 25);
		frame.getContentPane().add(tConfirm);
		tConfirm.setColumns(10);

		addLabel("lEmail", "Email", 230, 310, 154, 20);
		addLabel("lrequired", "*", 380, 310, 154, 20);

		tEmail = new JTextField();
		tEmail.setBounds(390, 310, 220, 25);
		frame.getContentPane().add(tEmail);
		tEmail.setColumns(10);

		addLabel("lSSN", "SSN", 230, 340, 154, 20);
		addLabel("lrequired", "*", 380, 330, 154, 20);

		tSSN = new JTextField();
		tSSN.setBounds(390, 340, 220, 25);
		frame.getContentPane().add(tSSN);
		tSSN.setColumns(10);

		addLabel("lSecQuestion", "Security Question", 230, 390, 154, 20);
		addLabel("lrequired", "*", 380, 390, 154, 20);

		tSecutiryQ = new JTextField();
		tSecutiryQ.setBounds(390, 390, 220, 25);
		frame.getContentPane().add(tSecutiryQ);
		tSecutiryQ.setColumns(10);

		addLabel("lSecAnswer", "Security Answer", 230, 420, 154, 20);
		addLabel("lrequired", "*", 380, 420, 154, 20);

		tSecutiryA = new JTextField();
		tSecutiryA.setBounds(390, 420, 220, 25);
		frame.getContentPane().add(tSecutiryA);
		tSecutiryA.setColumns(10);

		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaveData();
			}
		});
		btnRegister.setBounds(390, 460, 220, 28);
		frame.getContentPane().add(btnRegister);

		lError = new JLabel("");
		lError.setFont(new Font("Calibri", Font.BOLD, 20));
		lError.setBounds(350, 485, 520, 28);
		frame.getContentPane().add(lError);

		frame.setTitle("New User Registration");
	}

	private void addLabel(String labelName, String labelText, int x, int y, int w, int h) {
		JLabel lLabel = new JLabel(labelText);
		lLabel.setName(labelName);
		lLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		lLabel.setBounds(x, y, w, h);
		frame.getContentPane().add(lLabel);
	}

	@SuppressWarnings("deprecation")
	private void SaveData() {
		if (tfName.getText().isEmpty() || tlName.getText().isEmpty() || tUserName.getText().isEmpty()
				|| tPassword.getText().isEmpty() || tEmail.getText().isEmpty() || tSSN.getText().isEmpty()
				|| tSecutiryQ.getText().isEmpty() || tSecutiryA.getText().isEmpty()) {
			lError.setText("Please fill out all the required field and submit.");
			// lError.setStyle("-fx-font-size:15; -fx-text-fill: red;");
		} else {
			if (tPassword.getPassword().equals((tConfirm.getPassword()))) {
				lError.setText("Password and Confirm password do not match.");
			} else {
				String sql = "INSERT INTO `flights`.`users`" + 
						"(`firstName`,`lastName`,`address`,`zipcode`,`state`,`username`,`password`,`email`,"
						+ "`ssn`,`security_question`,`security_answer`,`isAdmin`)VALUES " + 
						"('"+ tfName.getText() +"', '"+tlName.getText()+"', '"+ tAddress.getText()+"', '" 
						+tZip.getText()+"', '" +tState.getText()+"', '"+ tUserName.getText() + "', '" + tPassword.getText() +"', '"
						+ tEmail.getText()+"', '" +tSSN.getText() + "', '" + tSecutiryQ.getText()+"', '" +tSecutiryA.getText()+ "', '0')";

				try {
					Connection myConn = DriverManager.getConnection(
							"jdbc:mysql://35.193.248.221:3306/?verifyServerCertificate=false&useSSL=true", "root",
							"Tdgiheay12");
					// create a statement
					Statement myStat = myConn.createStatement();
					myStat.executeUpdate(sql);
					
					lError.setText("A new user inserted successfully.");
					// lError.setStyle("-fx-font-size:15; -fx-text-fill: green;");

					Thread.sleep(3000);

					Login login = new Login();
					Login.main(null);

					Register.frame.hide();
				} catch (SQLException | InterruptedException e) {
					lError.setText(
							"A new user insert failed. \nThe user name " + tUserName.getText() + " is not available.");
					// lError.setStyle("-fx-font-size:15; -fx-text-fill: red;");
					System.out.println(e.getMessage());
				} 

			}
		}
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Log In");
		primaryStage.setResizable(false);
		AnchorPane anchor = new AnchorPane();
		anchor.setPadding(new Insets(10, 10, 10, 10));
		Label lTitle = new Label("Registration Form (* required field)");
		lTitle.setBounds(10, 10, 434, 28);
		lTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		lTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lTitle.setFont(new Font("Calibri", Font.BOLD, 23));
		frame.getContentPane().add(lTitle);
		
		
		anchor.getChildren().addAll();
		scene = new Scene(anchor, 850, 600);

		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.centerOnScreen();
	}
}

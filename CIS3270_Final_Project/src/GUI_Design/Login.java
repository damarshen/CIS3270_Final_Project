package GUI_Design;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class Login {
	//connection variable
	Connection myConn ; 
	//statement variable
	Statement myStat;
	//query variable
	ResultSet myRs;
	
	public static String user ="";
	//Jframe variable
	private static JFrame frame;
	//Creates a text field
	private JTextField textFieldUSer;
	//creates a password field
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//GUI frame
		frame = new JFrame();
		frame.setBounds(450, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		
		//Frame label
		JLabel loginLabel = new JLabel("Enter Your Username & Password");
		loginLabel.setBounds(0, 0, 434, 28);
		loginLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setFont(new Font("Calibri", Font.BOLD, 23));
		frame.getContentPane().add(loginLabel);
		
		//Label for username field
		JLabel username_label = new JLabel("Username:");
		username_label.setFont(new Font("Calibri", Font.BOLD, 20));
		username_label.setBounds(30, 68, 124, 20);
		frame.getContentPane().add(username_label);
		
		//Label for password field
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		passwordLabel.setBounds(27, 121, 124, 20);
		frame.getContentPane().add(passwordLabel);
		
		//Creates text field for username to be entered
		textFieldUSer = new JTextField();
		textFieldUSer.setBounds(161, 68, 124, 20);
		frame.getContentPane().add(textFieldUSer);
		textFieldUSer.setColumns(10);
		
		//Creates password field for password to be entered with action listener for enter key
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//Exception handling for connecting to the database
				try {
				//get a connection to the database
				Connection myConn = DriverManager.getConnection("jdbc:mysql://35.193.248.221:3306/?verifyServerCertificate=false&useSSL=true", "root", "Tdgiheay12");
				//create a statement
				Statement myStat = myConn.createStatement();
				//execute a query
				ResultSet myRs;	
					
				//collects user name from the user name text field and assigns to a string called user
				user = textFieldUSer.getText().trim();
				
				//Collects password from the password text field and assigns to a string called password
				String password = passwordField.getText().trim();
				
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
					Login.frame.setVisible(false);
					mainPage info =new mainPage();
					mainPage.main(null);
					
				}
				
				/**If user is not in database or password is incorrect, an error message is displayed prompting 
				 *  change in user name or password, attempt password recovery, 
				 *  or prompts the user to register if they do not have an account
				**/
				else if (count<1) {
					JOptionPane.showMessageDialog(null, "Username and password combination is either incorrect or the account does not exist.\n Please select The forgot password if your password is unknonwn, or the register option to create an account.");
				}
				
				}
			
				catch(Exception ex){
					
				}
			}
		});
		passwordField.setBounds(161, 121, 124, 20);
		frame.getContentPane().add(passwordField);
		
		//Log in button
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Exception handling for connecting to the database
				try {
				//get a connection to the database
				Connection myConn = DriverManager.getConnection("jdbc:mysql://35.193.248.221:3306/?verifyServerCertificate=false&useSSL=true", "root", "Tdgiheay12");
				//create a statement
				Statement myStat = myConn.createStatement();
				//execute a query
				ResultSet myRs;	
					
				//collects user name from the user name text field and assigns to a string called user
				user = textFieldUSer.getText().trim();
				
				//Collects password from the password text field and assigns to a string called password
				String password = passwordField.getText().trim();
				
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
					Login.frame.setVisible(false);
					mainPage info =new mainPage();
					mainPage.main(null);
					
				}
				
				/**If user is not in database or password is incorrect, an error message is displayed prompting 
				 *  change in user name or password, attempt password recovery, 
				 *  or prompts the user to register if they do not have an account
				**/
				else if (count<1) {
					JOptionPane.showMessageDialog(null, "Username and password combination is either incorrect or the account does not exist.\n Please select The forgot password if your password is unknonwn, or the register option to create an account.");
				}
				
				}
			
				catch(Exception ex){
					
				}
				
				

			}
		});
		btnLogIn.setBounds(30, 165, 141, 28);
		frame.getContentPane().add(btnLogIn);
		
		//Takes user to registration page
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register info =new Register();
				Register.main(null);
			}
		});
		btnRegister.setBounds(260, 165, 141, 28);
		frame.getContentPane().add(btnRegister);
		
		
		//Exits the program
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "The program will now exit.");
				System.exit(0);
			}
		});
		btnNewButton.setBounds(260, 211, 141, 28);
		frame.getContentPane().add(btnNewButton);
		
		//Takes user to password recovery page
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.frame.setVisible(false);
				passwordRecovery info =new passwordRecovery();
				passwordRecovery.main(null);
			}
		});
		btnForgotPassword.setBounds(30, 211, 141, 28);
		frame.getContentPane().add(btnForgotPassword);
	}
}

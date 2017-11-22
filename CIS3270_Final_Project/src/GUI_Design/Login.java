package GUI_Design;
import java.sql.*;
import Objects.Users.Users;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class Login {
	Connection myConn ;
	Statement myStat;
	ResultSet myRs;

	private JFrame frame;
	private JTextField textFieldUSer;
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		
		JLabel loginLabel = new JLabel("Enter Your Username & Password");
		loginLabel.setBounds(0, 0, 434, 28);
		loginLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setFont(new Font("Calibri", Font.BOLD, 23));
		frame.getContentPane().add(loginLabel);
		
		JLabel username_label = new JLabel("Username:");
		username_label.setFont(new Font("Calibri", Font.BOLD, 20));
		username_label.setBounds(30, 68, 124, 20);
		frame.getContentPane().add(username_label);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		passwordLabel.setBounds(27, 121, 124, 20);
		frame.getContentPane().add(passwordLabel);
		
		textFieldUSer = new JTextField();
		textFieldUSer.setBounds(161, 68, 124, 20);
		frame.getContentPane().add(textFieldUSer);
		textFieldUSer.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(161, 121, 124, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				//get a connection to the database
				Connection myConn = DriverManager.getConnection("jdbc:mysql://35.193.248.221:3306/?verifyServerCertificate=false&useSSL=true", "root", "Tdgiheay12");
				//create a statement
				Statement myStat = myConn.createStatement();
				//execute a query
				ResultSet myRs;	
					
				//collects username from the username text field and assigns to a string called user
				String user = textFieldUSer.getText().trim();
				
				//collects password from the password text field and assigns to a string called password
				String password = passwordField.getText().trim();
				
				//sql query to check if username and password is in database
				String sqlUserCheck = "SELECT `username` FROM `flights`.`user` where username = '" + user + "' and password = '" + password + "'";
				myRs = myStat.executeQuery(sqlUserCheck);
				
				int count = 0;
				
				//while loop that will determine if user is in the database
				while(myRs.next()){
					count = count + 1;
					
					}
				
				//if user is in the database and the pasword is correct it will take user to log in page
				if (count==1) {
					
					mainPage info =new mainPage();
					mainPage.main(null);
					
				}
				
				else if (count<1) {
					JOptionPane.showMessageDialog(null, "Username and password combination is either incorrect or the account does not exist.\n Please select The forgot password if your password is unknonwn, or the register option to create an account");
				}
				
				}
			
				catch(Exception ex){
					
				}
				
				

			}
		});
		btnLogIn.setBounds(30, 165, 141, 28);
		frame.getContentPane().add(btnLogIn);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register info =new Register();
				Register.main(null);
			}
		});
		btnRegister.setBounds(260, 165, 141, 28);
		frame.getContentPane().add(btnRegister);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setBounds(260, 211, 141, 28);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setBounds(30, 211, 141, 28);
		frame.getContentPane().add(btnForgotPassword);
	}
}

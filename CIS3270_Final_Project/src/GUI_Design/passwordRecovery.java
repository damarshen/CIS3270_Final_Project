package GUI_Design;

import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class passwordRecovery {

	//initializes frame and text fields 
	private static JFrame frame;
	private JTextField usernameText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					passwordRecovery window = new passwordRecovery();
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
	public passwordRecovery() {
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
		
		//label for frame
		JLabel passwordRecoveryLbl = new JLabel("Recover Your Password");
		passwordRecoveryLbl.setHorizontalAlignment(SwingConstants.CENTER);
		passwordRecoveryLbl.setFont(new Font("Calibri", Font.BOLD, 24));
		passwordRecoveryLbl.setBounds(0, 1, 434, 28);
		passwordRecoveryLbl.setBackground(new Color(240, 240, 240));
		passwordRecoveryLbl.setVerticalAlignment(SwingConstants.BOTTOM);
		frame.getContentPane().add(passwordRecoveryLbl);
		
		//label for username fields
		JLabel usernameLbl = new JLabel("Enter Your Username Below:");
		usernameLbl.setFont(new Font("Calibri", Font.BOLD, 18));
		usernameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLbl.setBounds(0, 83, 434, 33);
		frame.getContentPane().add(usernameLbl);
		
		//text field for user to enter username
		usernameText = new JTextField();
		usernameText.setBounds(121, 124, 197, 28);
		frame.getContentPane().add(usernameText);
		usernameText.setColumns(10);
		
		//button and action listener to initialize action of recovering passwords
		JButton recoverBttn = new JButton("Recover Password");
		recoverBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//exception handling for database connection
				try {
					
					//string to hold security question once received from database
					String secQuest = "";
					
					//string to hold security question answer once received from database
					String secAnswer="";
					
					//string for user answer to security question to be compared to database entry
					String userAnswer = "";
					
					//string for password to be held once recieved from the database
					String password = "";
					
					//get a connection to the database
					Connection myConn = DriverManager.getConnection("jdbc:mysql://35.193.248.221:3306/?verifyServerCertificate=false&useSSL=true", "root", "Tdgiheay12");
					//create a statement
					Statement myStat = myConn.createStatement();
					//creates result set
					ResultSet myRs;	
						
					//collects user name from the user name text field and assigns to a string called user
					String user = usernameText.getText().trim();
				
					//SQL query to check if username is in database
					String sqlSecCheck = "SELECT * FROM `flights`.`user` where username = '" + user + "'";
					
					//executes above query
					myRs = myStat.executeQuery(sqlSecCheck);
					
					//Creates a variable for future checking if result set is valid
					int count = 0;
					
					//While loop that will determine if user is in the database
					while(myRs.next()){
						
						count = count + 1;
						//sets security question to database entry 
						secQuest = myRs.getString("security_question");
						
						//sets security answer from database to be compared to user answer
						secAnswer = myRs.getString("security_answer");
						
						//stores password from database
						password = myRs.getString("password");
						
						
						
						}
					//if username is in database these actions will be performed:
					if (count==1) {
							//prompts user to answer security question
							userAnswer = JOptionPane.showInputDialog(secQuest);
					}
					//if account is not in database it will perform these actions:
					else if (count<1) {
						//informs user that the username they entered is not in the system
						JOptionPane.showMessageDialog(null, "There is no user with the username " + user);
					}
					
					//if user is prompted for security answer it will compare to the value in the database
					if (secAnswer.equals(userAnswer)) {
						//if value is the same as database it will display users password
						JOptionPane.showMessageDialog(null, "the password for your account is: " + password);
					}
					////if user is prompted for security answer it will compare to the value in the database and is not equal
					else  {
						//will inform user that their answer to he security question is incorrect
						JOptionPane.showMessageDialog(null, "That answer is incotrrect. Please try again.");
					}
					
				}
					
					catch (Exception ex) {
						
					}
				
			}
		});
		recoverBttn.setBounds(66, 187, 150, 23);
		frame.getContentPane().add(recoverBttn);
		
		//button to return to login page
		JButton loginBttn = new JButton("Return to Login");
		loginBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login info =new Login();
				Login.main(null);
				passwordRecovery.frame.setVisible(false);
			}
		});
		loginBttn.setBounds(245, 187, 150, 23);
		frame.getContentPane().add(loginBttn);
	}
}

package GUI_Design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class passwordRecovery {

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
		
		JLabel passwordRecoveryLbl = new JLabel("Recover Your Password");
		passwordRecoveryLbl.setHorizontalAlignment(SwingConstants.CENTER);
		passwordRecoveryLbl.setFont(new Font("Calibri", Font.BOLD, 24));
		passwordRecoveryLbl.setBounds(0, 1, 434, 28);
		passwordRecoveryLbl.setBackground(new Color(240, 240, 240));
		passwordRecoveryLbl.setVerticalAlignment(SwingConstants.BOTTOM);
		frame.getContentPane().add(passwordRecoveryLbl);
		
		JLabel usernameLbl = new JLabel("Enter Your Username Below:");
		usernameLbl.setFont(new Font("Calibri", Font.BOLD, 18));
		usernameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLbl.setBounds(0, 83, 434, 33);
		frame.getContentPane().add(usernameLbl);
		
		usernameText = new JTextField();
		usernameText.setBounds(121, 124, 197, 28);
		frame.getContentPane().add(usernameText);
		usernameText.setColumns(10);
		
		JButton recoverBttn = new JButton("Recover Password");
		recoverBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//get a connection to the database
					Connection myConn = DriverManager.getConnection("jdbc:mysql://35.193.248.221:3306/?verifyServerCertificate=false&useSSL=true", "root", "Tdgiheay12");
					//create a statement
					Statement myStat = myConn.createStatement();
					//execute a query
					ResultSet myRs;	
						
					//collects user name from the user name text field and assigns to a string called user
					String user = usernameText.getText().trim();
				
					//SQL query to check if user  name and password is in database
					String sqlUserCheck = "SELECT `security_question` FROM `flights`.`user` where username = '" + user +"'";
					myRs = myStat.executeQuery(sqlUserCheck);
					
					//Creates a variable for future checking
					int count = 0;
					
					//While loop that will determine if user is in the database
					while(myRs.next()){
						
						count = count + 1;
						
						}
				}
					
					catch (Exception ex) {
						
					}
				
			}
		});
		recoverBttn.setBounds(245, 187, 150, 23);
		frame.getContentPane().add(recoverBttn);
		
		JButton loginBttn = new JButton("Return to Login");
		loginBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login info =new Login();
				Login.main(null);
				passwordRecovery.frame.setVisible(false);
			}
		});
		loginBttn.setBounds(48, 187, 150, 23);
		frame.getContentPane().add(loginBttn);
	}
}

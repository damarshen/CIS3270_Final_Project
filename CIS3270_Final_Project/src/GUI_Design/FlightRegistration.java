package GUI_Design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import Objects.Users.*;

public class FlightRegistration {

	private JFrame frame;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtZipCode;
	private JTextField txtUserName;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JTextField txtSSN;
	private JTextField txtSecurityQuestion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightRegistration window = new FlightRegistration();
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
	public FlightRegistration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 998, 726);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 778, 47);
		frame.getContentPane().add(panel);
		
		JLabel lblFlightsRegistration = new JLabel("Flights Registration");
		lblFlightsRegistration.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblFlightsRegistration);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(320, 111, 108, 26);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("First / Last Name");
		lblNewLabel_1.setBounds(85, 106, 138, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(443, 111, 138, 26);
		frame.getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblAdress = new JLabel("Address");
		lblAdress.setBounds(85, 168, 69, 20);
		frame.getContentPane().add(lblAdress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(320, 165, 261, 26);
		frame.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("City / State / Zip");
		lblNewLabel.setBounds(85, 210, 138, 20);
		frame.getContentPane().add(lblNewLabel);
		
		txtCity = new JTextField();
		txtCity.setBounds(320, 207, 99, 26);
		frame.getContentPane().add(txtCity);
		txtCity.setColumns(10);
		
		txtState = new JTextField();
		txtState.setBounds(434, 207, 47, 26);
		frame.getContentPane().add(txtState);
		txtState.setColumns(10);
		
		txtZipCode = new JTextField();
		txtZipCode.setBounds(496, 207, 85, 26);
		frame.getContentPane().add(txtZipCode);
		txtZipCode.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setBounds(85, 269, 85, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(85, 311, 69, 20);
		frame.getContentPane().add(lblPassword);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(320, 266, 146, 26);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(85, 370, 69, 20);
		frame.getContentPane().add(lblNewLabel_4);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(320, 367, 146, 26);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSubmit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				// save user registration data
				Users user = new Users();
				user.setFirstName(txtFirstName.getText());
				user.setLastName(txtLastName.getText());
				user.setAddress(txtAddress.getText());
				//user.setCity(txtCity.getText());
				user.setState(txtState.getText());
				//user.setZipCode(txtZipCode.getText());
				user.setUsername(txtUserName.getText());
				user.setPassword(txtPassword.toString());
				user.setEmail(txtEmail.getText());
				user.setSsn(txtSSN.getText());
				user.setSecurityQuestion(txtSecurityQuestion.getText());
				
				
			}
		});
		btnSubmit.setBounds(320, 557, 146, 29);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblSsn = new JLabel("SSN");
		lblSsn.setBounds(85, 423, 69, 20);
		frame.getContentPane().add(lblSsn);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(320, 308, 146, 26);
		frame.getContentPane().add(txtPassword);
		
		txtSSN = new JTextField();
		txtSSN.setBounds(320, 420, 146, 26);
		frame.getContentPane().add(txtSSN);
		txtSSN.setColumns(10);
		
		txtSecurityQuestion = new JTextField();
		txtSecurityQuestion.setBounds(320, 471, 146, 26);
		frame.getContentPane().add(txtSecurityQuestion);
		txtSecurityQuestion.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Security Question for pw");
		lblNewLabel_2.setBounds(85, 474, 184, 20);
		frame.getContentPane().add(lblNewLabel_2);
	}
}

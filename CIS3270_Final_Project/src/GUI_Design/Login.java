package GUI_Design;
import Objects.Users.Users;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

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
		
		JLabel LoginLabel = new JLabel("Enter Your Username & Password");
		LoginLabel.setBounds(0, 0, 434, 28);
		LoginLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		LoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LoginLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		frame.getContentPane().add(LoginLabel);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(10, 60, 124, 28);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(10, 113, 124, 28);
		frame.getContentPane().add(lblPassword);
		
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

			}
		});
		btnLogIn.setBounds(82, 201, 89, 23);
		frame.getContentPane().add(btnLogIn);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(181, 201, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setBounds(280, 201, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}

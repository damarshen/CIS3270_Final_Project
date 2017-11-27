package GUI_Design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;

public class mainPage {

	static JFrame frame;
	Login info = new Login();
	String user = info.user;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPage window = new mainPage();
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
	public mainPage() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1390, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel accountLabel = new JLabel("logged in as: "+ user);
		accountLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		accountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		accountLabel.setBounds(1072, 0, 173, 23);
		frame.getContentPane().add(accountLabel);
		
		//Logs user out and returns them to log in screen
		JButton logoutButton = new JButton("Log Out");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login info =new Login();
				Login.main(null);
				mainPage.frame.setVisible(false);
			}
		});
		logoutButton.setFont(new Font("Calibri", Font.PLAIN, 15));
		logoutButton.setBounds(1265, 1, 89, 23);
		frame.getContentPane().add(logoutButton);
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Registration {

	private JFrame frame;
	private JTextField txtTest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
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
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 770, 590);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtTest = new JTextField();
		txtTest.setText("test");
		frame.getContentPane().add(txtTest, BorderLayout.CENTER);
		txtTest.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		frame.getContentPane().add(lblFirstName, BorderLayout.WEST);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		frame.getContentPane().add(btnRegister, BorderLayout.SOUTH);
	}

}

package main.java.Models;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class EmployeeFrame {

	private JFrame frame;
	private JTextField first_name;
	private JTextField last_name;
	private JTextField pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeFrame window = new EmployeeFrame();
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
	public EmployeeFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 928, 688);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		first_name = new JTextField();
		first_name.setBounds(234, 111, 165, 20);
		frame.getContentPane().add(first_name);
		first_name.setColumns(10);
		
		JLabel firstName = new JLabel("First Name");
		firstName.setBounds(141, 114, 79, 14);
		frame.getContentPane().add(firstName);
		
		JLabel lastName = new JLabel("Last Name");
		lastName.setBounds(141, 164, 79, 14);
		frame.getContentPane().add(lastName);
		
		last_name = new JTextField();
		last_name.setColumns(10);
		last_name.setBounds(234, 161, 165, 20);
		frame.getContentPane().add(last_name);
		
		JLabel password = new JLabel("Password");
		password.setBounds(141, 211, 79, 14);
		frame.getContentPane().add(password);
		
		pw = new JTextField();
		pw.setColumns(10);
		pw.setBounds(234, 208, 165, 20);
		frame.getContentPane().add(pw);
		
		JLabel lblNewLabel = new JLabel("Add New Employee");
		lblNewLabel.setBounds(173, 52, 122, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}

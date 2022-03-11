package main.java.Models;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame {

	private JFrame frmTestrun;
	private JTextField ID;
	private JTextField Name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frmTestrun.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	Connection con;
	PreparedStatement pst;
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTestrun = new JFrame();
		frmTestrun.setTitle("Testrun");
		frmTestrun.setBounds(100, 100, 1723, 756);
		frmTestrun.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTestrun.getContentPane().setLayout(null);
		
		ID = new JTextField();
		ID.setBounds(309, 168, 280, 20);
		frmTestrun.getContentPane().add(ID);
		ID.setColumns(10);
		
		Name = new JTextField();
		Name.setBounds(309, 199, 280, 20);
		frmTestrun.getContentPane().add(Name);
		Name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(237, 171, 46, 14);
		frmTestrun.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(237, 202, 46, 14);
		frmTestrun.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String Stateid = ID.getText();
					String Statename = Name.getText();
					
					Class.forName("org.postgresql.Driver");
					con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cardealership", "postgres", "YOUR PASSWORD");
					
					String sql = "INSERT INTO State(ID, Name) VALUES(?, ?)";
					PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1,Stateid);
					statement.setString(2,Statename);
					statement.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Added");
					ID.setText("");
					ID.requestFocus();
					Name.setText("");
					Name.requestFocus();
				}
				catch(Exception e1) {
					System.out.println(e1.toString());
				}
			}
		});
		btnNewButton.setBounds(237, 252, 89, 23);
		frmTestrun.getContentPane().add(btnNewButton);
	}
}
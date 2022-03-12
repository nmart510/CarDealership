package main.java;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import main.java.Models.Employee;

public class MainFrame {

	private JFrame dealershipWindow;
	private Dealership ds = new Dealership();
	
	Connection con;
	PreparedStatement pst;
	DefaultTableModel employee = new DefaultTableModel();
	private JTable employeeTable = new JTable(employee);
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.dealershipWindow.setVisible(true);
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
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		dealershipWindow = new JFrame();
		dealershipWindow.setTitle("Testrun");
		dealershipWindow.setBounds(100, 100, 1723, 756);
		dealershipWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dealershipWindow.getContentPane().setLayout(null);

		/**
		 * First row of employee table.
		 */
		
		employee.addColumn("Employee ID");
		employee.addColumn("First Name");
		employee.addColumn("Last Name");
		employee.addRow(new Object[] {"Employee ID", "First Name", "Last Name"});
		
		/**
		 * Employee Table and Print Button that prints out employee table.
		 */
		
		JButton printEmployeesButton = new JButton("Print All Employees");
		printEmployeesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				try {
					List<Employee> empl = ds.getEmployees();
					empl.forEach(e -> {
						employee.addRow(new Object[] {e.getID(), e.getFirst_name(), e.getLast_name()});
					});
				}
				catch(Exception e2) {
					System.out.println(e2.toString());
				}
			}
		});
		printEmployeesButton.setBounds(1256, 261, 143, 23);
		dealershipWindow.getContentPane().add(printEmployeesButton);
		employeeTable.setBounds(1256, 47, 412, 203);
		dealershipWindow.getContentPane().add(employeeTable);
		JLabel employeeTableLabel = new JLabel("Employees");
		employeeTableLabel.setBounds(1256, 22, 127, 14);
		dealershipWindow.getContentPane().add(employeeTableLabel);
		
		
	}
}
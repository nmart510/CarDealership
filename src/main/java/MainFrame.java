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

import main.java.Models.Customer;
import main.java.Models.Employee;
import main.java.Models.Sales;
import main.java.Models.Vehicle;

public class MainFrame {

	private JFrame dealershipWindow;
	private Dealership ds = new Dealership();
	
	Connection con;
	PreparedStatement pst;
	DefaultTableModel employee = new DefaultTableModel();
	DefaultTableModel customer = new DefaultTableModel();
	DefaultTableModel vehicle = new DefaultTableModel();
	DefaultTableModel sales = new DefaultTableModel();
	private JTable employeeTable = new JTable(employee);
	private JTable customerTable = new JTable(customer);
	private JTable vehicleTable = new JTable(vehicle);
	private JTable salesTable = new JTable(sales);
	
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
		printEmployeesButton.setBounds(434, 18, 143, 23);
		dealershipWindow.getContentPane().add(printEmployeesButton);
		employeeTable.setBounds(10, 47, 567, 296);
		dealershipWindow.getContentPane().add(employeeTable);
		JLabel employeeTableLabel = new JLabel("Employees");
		employeeTableLabel.setBounds(10, 22, 127, 14);
		dealershipWindow.getContentPane().add(employeeTableLabel);
		
		/**
		 * First row of customer table.
		 */
		
		customer.addColumn("Customer ID");
		customer.addColumn("First Name");
		customer.addColumn("Last Name");
		customer.addColumn("Email");
		customer.addColumn("Phone Number");
		customer.addColumn("Address");
		customer.addColumn("City");
		customer.addColumn("Zip Code");
		customer.addColumn("State");
		customer.addRow(new Object[] {"Customer ID", "First Name", "Last Name", "Email", "Phone Number", "Address", "City", "Zip Code", "State"});
		
		/**
		 * Customer Table and Print Button that prints out customer table.
		 */
		
		JButton printCustomersButton = new JButton("Print All Customers");
		printCustomersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				try { //
					List<Customer> custl = ds.getCustomers();
					custl.forEach(e -> {
						customer.addRow(new Object[] {e.getID(), e.getFirst_name(), e.getLast_name(), e.getEmail(), e.getPhone_num(), e.getAddress(), 
								e.getCity(), e.getZip_code(), e.getState()});
					});
				}
				catch(Exception e2) {
					System.out.println(e2.toString());
				}
			}
		});
		printCustomersButton.setBounds(1525, 18, 143, 23);
		dealershipWindow.getContentPane().add(printCustomersButton);
		customerTable.setBounds(1101, 47, 567, 296);
		dealershipWindow.getContentPane().add(customerTable);
		JLabel customerTableLabel = new JLabel("Customers");
		customerTableLabel.setBounds(1101, 22, 127, 14);
		dealershipWindow.getContentPane().add(customerTableLabel);
		
		/**
		 * First row of vehicle table.
		 */
		
		vehicle.addColumn("Vehicle ID");
		vehicle.addColumn("VIN");
		vehicle.addColumn("Make");
		vehicle.addColumn("Model");
		vehicle.addColumn("Year");
		vehicle.addColumn("Trim");
		vehicle.addColumn("MSRP");
		vehicle.addColumn("Color");
		vehicle.addColumn("Parking Stall");
		vehicle.addColumn("Odometer");
		vehicle.addColumn("New");
		vehicle.addRow(new Object[] {"Vehicle ID", "VIN","Make", "Model", "Year", "Trim", "MSRP", "Color", "Parking Stall", "Odometer", "New"});
		
		/**
		 * Vehicle Table and Print Button that prints out vehicle table.
		 */
		
		JButton printVehiclesButton = new JButton("Print All Vehicles");
		printVehiclesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				try { //
					List<Vehicle> vehl = ds.getVehicles();
					vehl.forEach(e -> {
						if (e.getTrim() == null) {
							if(e.getParkingStall() == 0) {
								vehicle.addRow(new Object[] {e.getID(), e.getVin(), e.getMake(), e.getModel(), e.getYear(), " ", e.getMSRP(), e.getColor(), " ", 
										e.getOdometer(), e.isNew()});
							}
							else {
								vehicle.addRow(new Object[] {e.getID(), e.getVin(), e.getMake(), e.getModel(), e.getYear(), " ", e.getMSRP(), e.getColor(), e.getParkingStall(), 
										e.getOdometer(), e.isNew()});
							}
						}
						else {
							vehicle.addRow(new Object[] {e.getID(), e.getVin(), e.getMake(), e.getModel(), e.getYear(), e.getTrim(), e.getMSRP(), e.getColor(), e.getParkingStall(), 
									e.getOdometer(), e.isNew()});
						}
					});
				}
				catch(Exception e2) {
					System.out.println(e2.toString());
				}
			}
		});
		printVehiclesButton.setBounds(434, 381, 143, 23);
		dealershipWindow.getContentPane().add(printVehiclesButton);
		vehicleTable.setBounds(10, 410, 567, 296);
		dealershipWindow.getContentPane().add(vehicleTable);
		JLabel vehiclesTableLabel = new JLabel("Vehicles");
		vehiclesTableLabel.setBounds(10, 385, 127, 14);
		dealershipWindow.getContentPane().add(vehiclesTableLabel);
		
		/**
		 * First row of sales table.
		 */
		
		sales.addColumn("Sale ID");
		sales.addColumn("Vehicle ID");
		sales.addColumn("Customer ID");
		sales.addColumn("Employee ID");
		sales.addColumn("Date");
		sales.addColumn("Price");
		sales.addColumn("Purchased");
		sales.addRow(new Object[] {"Sale ID", "Vehicle ID", "Customer ID", "Employee ID", "Date", "Price", "Purchased"});
		
		/**
		 * Sales Table and Print Button that prints out sales table.
		 */
		
		JButton printsalesButton = new JButton("Print All Sales");
		printsalesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				try { //
					List<Sales> salel = ds.getSales();
					salel.forEach(e -> {
						sales.addRow(new Object[] {e.getID(), e.getVehicleID(), e.getCustomerID(), e.getEmployeeID(), e.getDate(), e.getPrice(), 
								e.isDealerPurchase()});
					});
				}
				catch(Exception e2) {
					System.out.println(e2.toString());
				}
			}
		});
		printsalesButton.setBounds(1525, 381, 143, 23);
		dealershipWindow.getContentPane().add(printsalesButton);
		salesTable.setBounds(1101, 410, 567, 296);
		dealershipWindow.getContentPane().add(salesTable);
		JLabel salesTableLabel = new JLabel("Sales");
		salesTableLabel.setBounds(1101, 385, 127, 14);
		dealershipWindow.getContentPane().add(salesTableLabel);
		
	}
}
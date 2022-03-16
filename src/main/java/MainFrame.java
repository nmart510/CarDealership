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
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

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
	private JTextField VINText;
	private JTextField TrimText;
	private JTextField MSRPText;
	private JTextField ColorText;
	private JTextField ParkingText;
	private JTextField OdometerText;
	private JTextField isNewText;
	private JTextField MakeText;
	private JTextField YearText;
	private JTextField ModelText;
	private JTextField FSText;
	private JTextField LSText;
	private JTextField EmailText;
	private JTextField PhoneText;
	private JTextField AddressText;
	private JTextField CityText;
	private JTextField ZIPText;
	private JTextField StateText;
	private JTextField EIDText;
	private JTextField EFSText;
	private JTextField ELSText;
	private JTextField SVText;
	private JTextField SCText;
	private JTextField SEText;
	private JTextField DateText;
	private JTextField PriceText;
	private JTextField PurchaseLabel;
	private JTextField EIDFilterText;
	private JTextField DateFilterText;
	private JTextField ColorFilterText;
	private JTextField MakeFilterText;
	
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
		dealershipWindow.setTitle("Dealership");
		dealershipWindow.setBounds(100, 100, 1880, 980);
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
				employee.setRowCount(0);
				employee.addRow(new Object[] {"Employee ID", "First Name", "Last Name"});
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
		printEmployeesButton.setBounds(1674, 593, 180, 23);
		dealershipWindow.getContentPane().add(printEmployeesButton);
		employeeTable.setBounds(1287, 627, 567, 245);
		dealershipWindow.getContentPane().add(employeeTable);
		JLabel employeeTableLabel = new JLabel("Employees");
		employeeTableLabel.setBounds(1287, 597, 127, 14);
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
				customer.setRowCount(0);
				customer.addRow(new Object[] {"Customer ID", "First Name", "Last Name", "Email", "Phone Number", "Address", "City", "Zip Code", "State"});
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
		printCustomersButton.setBounds(1674, 18, 180, 23);
		dealershipWindow.getContentPane().add(printCustomersButton);
		customerTable.setBounds(1287, 47, 567, 245);
		dealershipWindow.getContentPane().add(customerTable);
		JLabel customerTableLabel = new JLabel("Customers");
		customerTableLabel.setBounds(1287, 22, 127, 14);
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
				vehicle.setRowCount(0);
				vehicle.addRow(new Object[] {"Vehicle ID", "VIN","Make", "Model", "Year", "Trim", "MSRP", "Color", "Parking Stall", "Odometer", "New"});
				try { //
					List<Vehicle> vehl = ds.getVehicles();
					vehl.forEach(e -> {
						if (e.getTrim() == null) {
							if(e.getParkingStall() == null) {
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
		printVehiclesButton.setBounds(81, 18, 180, 23);
		dealershipWindow.getContentPane().add(printVehiclesButton);
		vehicleTable.setBounds(10, 47, 1232, 220);
		dealershipWindow.getContentPane().add(vehicleTable);
		JLabel vehiclesTableLabel = new JLabel("Vehicles");
		vehiclesTableLabel.setBounds(10, 22, 127, 14);
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
				sales.setRowCount(0);
				sales.addRow(new Object[] {"Sale ID", "Vehicle ID", "Customer ID", "Employee ID", "Date", "Price", "Purchased"});
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
		printsalesButton.setBounds(1674, 303, 180, 23);
		dealershipWindow.getContentPane().add(printsalesButton);
		salesTable.setBounds(1287, 337, 567, 245);
		dealershipWindow.getContentPane().add(salesTable);
		JLabel salesTableLabel = new JLabel("Sales");
		salesTableLabel.setBounds(1287, 307, 127, 14);
		dealershipWindow.getContentPane().add(salesTableLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Add New Car", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 278, 265, 313);
		dealershipWindow.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel VINLabel = new JLabel("VIN");
		VINLabel.setBounds(10, 27, 46, 14);
		panel.add(VINLabel);
		
		JLabel TrimLabel = new JLabel("Trim");
		TrimLabel.setBounds(10, 52, 46, 14);
		panel.add(TrimLabel);
		
		JLabel MSRPLabel = new JLabel("MSRP");
		MSRPLabel.setBounds(10, 77, 46, 14);
		panel.add(MSRPLabel);
		
		JLabel ColorLabel = new JLabel("Color");
		ColorLabel.setBounds(10, 102, 46, 14);
		panel.add(ColorLabel);
		
		JLabel ParkingLabel = new JLabel("Parking Stall");
		ParkingLabel.setBounds(10, 127, 135, 14);
		panel.add(ParkingLabel);
		
		JLabel OdometerLabel = new JLabel("Odometer");
		OdometerLabel.setBounds(10, 152, 69, 14);
		panel.add(OdometerLabel);
		
		JLabel isNewLabel = new JLabel("New");
		isNewLabel.setBounds(10, 177, 69, 14);
		panel.add(isNewLabel);
		
		JLabel MakeLabel = new JLabel("Make");
		MakeLabel.setBounds(10, 202, 69, 14);
		panel.add(MakeLabel);
		
		JLabel YearLabel = new JLabel("Year");
		YearLabel.setBounds(10, 227, 69, 14);
		panel.add(YearLabel);
		
		JLabel ModelLabel = new JLabel("Model");
		ModelLabel.setBounds(10, 252, 69, 14);
		panel.add(ModelLabel);
		
		JButton AddCarButton = new JButton("Add Car");
		AddCarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int odometer, year;
				String vin, modelName, trim, color, stall, makeName;
				double msrp;
				boolean isNew;
				
				vin = VINText.getText();
				makeName = MakeText.getText();
				modelName = ModelText.getText();
				year = Integer.parseInt(YearText.getText());
				trim = TrimText.getText();
				msrp = Double.parseDouble(MSRPText.getText());
				color = ColorText.getText();
				stall = ParkingText.getText();
				odometer = Integer.parseInt(OdometerText.getText());
				if(isNewText.getText().equalsIgnoreCase("true")) {
					isNew = true;
				}
				else {
					isNew = false;
				}
				ds.addVehicle(vin, makeName, modelName, year, trim, msrp, color, stall, odometer, isNew);
			}
		});
		AddCarButton.setBounds(10, 279, 245, 23);
		panel.add(AddCarButton);
		
		VINText = new JTextField();
		VINText.setBounds(155, 24, 100, 20);
		panel.add(VINText);
		VINText.setColumns(10);
		
		TrimText = new JTextField();
		TrimText.setColumns(10);
		TrimText.setBounds(155, 49, 100, 20);
		panel.add(TrimText);
		
		MSRPText = new JTextField();
		MSRPText.setColumns(10);
		MSRPText.setBounds(155, 74, 100, 20);
		panel.add(MSRPText);
		
		ColorText = new JTextField();
		ColorText.setColumns(10);
		ColorText.setBounds(155, 99, 100, 20);
		panel.add(ColorText);
		
		ParkingText = new JTextField();
		ParkingText.setColumns(10);
		ParkingText.setBounds(155, 124, 100, 20);
		panel.add(ParkingText);
		
		OdometerText = new JTextField();
		OdometerText.setColumns(10);
		OdometerText.setBounds(155, 149, 100, 20);
		panel.add(OdometerText);
		
		isNewText = new JTextField();
		isNewText.setColumns(10);
		isNewText.setBounds(155, 174, 100, 20);
		panel.add(isNewText);
		
		MakeText = new JTextField();
		MakeText.setColumns(10);
		MakeText.setBounds(155, 199, 100, 20);
		panel.add(MakeText);
		
		YearText = new JTextField();
		YearText.setColumns(10);
		YearText.setBounds(155, 224, 100, 20);
		panel.add(YearText);
		
		ModelText = new JTextField();
		ModelText.setColumns(10);
		ModelText.setBounds(155, 249, 100, 20);
		panel.add(ModelText);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Add New Customer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(281, 278, 265, 313);
		dealershipWindow.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel FSLabel = new JLabel("First Name");
		FSLabel.setBounds(10, 27, 67, 14);
		panel_1.add(FSLabel);
		
		JLabel LSLabel = new JLabel("Last Name");
		LSLabel.setBounds(10, 52, 67, 14);
		panel_1.add(LSLabel);
		
		JLabel EmailLabel = new JLabel("Email");
		EmailLabel.setBounds(10, 77, 67, 14);
		panel_1.add(EmailLabel);
		
		JLabel PhoneLabel = new JLabel("Phone Number");
		PhoneLabel.setBounds(10, 102, 135, 14);
		panel_1.add(PhoneLabel);
		
		JLabel AddressLabel = new JLabel("Address");
		AddressLabel.setBounds(10, 127, 77, 14);
		panel_1.add(AddressLabel);
		
		JLabel CityLabel = new JLabel("City");
		CityLabel.setBounds(10, 152, 77, 14);
		panel_1.add(CityLabel);
		
		JLabel ZipLabel = new JLabel("Zip Code");
		ZipLabel.setBounds(10, 177, 77, 14);
		panel_1.add(ZipLabel);
		
		JLabel StateLabel = new JLabel("State");
		StateLabel.setBounds(10, 202, 77, 14);
		panel_1.add(StateLabel);
		
		FSText = new JTextField();
		FSText.setBounds(155, 24, 100, 20);
		panel_1.add(FSText);
		FSText.setColumns(10);
		
		LSText = new JTextField();
		LSText.setColumns(10);
		LSText.setBounds(155, 49, 100, 20);
		panel_1.add(LSText);
		
		EmailText = new JTextField();
		EmailText.setColumns(10);
		EmailText.setBounds(155, 74, 100, 20);
		panel_1.add(EmailText);
		
		PhoneText = new JTextField();
		PhoneText.setColumns(10);
		PhoneText.setBounds(155, 99, 100, 20);
		panel_1.add(PhoneText);
		
		AddressText = new JTextField();
		AddressText.setColumns(10);
		AddressText.setBounds(155, 124, 100, 20);
		panel_1.add(AddressText);
		
		CityText = new JTextField();
		CityText.setColumns(10);
		CityText.setBounds(155, 149, 100, 20);
		panel_1.add(CityText);
		
		ZIPText = new JTextField();
		ZIPText.setColumns(10);
		ZIPText.setBounds(155, 174, 100, 20);
		panel_1.add(ZIPText);
		
		StateText = new JTextField();
		StateText.setColumns(10);
		StateText.setBounds(155, 199, 100, 20);
		panel_1.add(StateText);
		
		JButton AddCustomerButton = new JButton("Add Customer");
		AddCustomerButton.setBounds(10, 279, 245, 23);
		panel_1.add(AddCustomerButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Add Employee", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(550, 278, 265, 313);
		dealershipWindow.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel EIDLabel = new JLabel("Employee ID");
		EIDLabel.setBounds(10, 27, 135, 14);
		panel_2.add(EIDLabel);
		
		JLabel EFSLabel = new JLabel("First Name");
		EFSLabel.setBounds(10, 52, 68, 14);
		panel_2.add(EFSLabel);
		
		JLabel ELSLabel = new JLabel("Last Name");
		ELSLabel.setBounds(10, 77, 68, 14);
		panel_2.add(ELSLabel);
		
		EIDText = new JTextField();
		EIDText.setBounds(155, 24, 100, 20);
		panel_2.add(EIDText);
		EIDText.setColumns(10);
		
		EFSText = new JTextField();
		EFSText.setColumns(10);
		EFSText.setBounds(155, 49, 100, 20);
		panel_2.add(EFSText);
		
		ELSText = new JTextField();
		ELSText.setColumns(10);
		ELSText.setBounds(155, 74, 100, 20);
		panel_2.add(ELSText);
		
		JButton AddEmployeeButton = new JButton("Add Employee");
		AddEmployeeButton.setBounds(10, 279, 245, 23);
		panel_2.add(AddEmployeeButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Make a Sale", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(819, 278, 265, 313);
		dealershipWindow.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel SVLabel = new JLabel("Vehicle ID");
		SVLabel.setBounds(10, 27, 62, 14);
		panel_3.add(SVLabel);
		
		JLabel SCLabel = new JLabel("Customer ID");
		SCLabel.setBounds(10, 50, 135, 14);
		panel_3.add(SCLabel);
		
		JLabel SElabel = new JLabel("Employee ID");
		SElabel.setBounds(10, 75, 135, 14);
		panel_3.add(SElabel);
		
		JLabel DateLabel = new JLabel("Date ");
		DateLabel.setBounds(10, 99, 62, 14);
		panel_3.add(DateLabel);
		
		JLabel PriceLabel = new JLabel("Price");
		PriceLabel.setBounds(10, 124, 62, 14);
		panel_3.add(PriceLabel);
		
		JLabel DealerPLabel = new JLabel("Purchased by Dealership");
		DealerPLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DealerPLabel.setBounds(10, 149, 245, 14);
		panel_3.add(DealerPLabel);
		
		SVText = new JTextField();
		SVText.setBounds(155, 24, 100, 20);
		panel_3.add(SVText);
		SVText.setColumns(10);
		
		SCText = new JTextField();
		SCText.setColumns(10);
		SCText.setBounds(155, 47, 100, 20);
		panel_3.add(SCText);
		
		SEText = new JTextField();
		SEText.setColumns(10);
		SEText.setBounds(155, 72, 100, 20);
		panel_3.add(SEText);
		
		DateText = new JTextField();
		DateText.setColumns(10);
		DateText.setBounds(155, 96, 100, 20);
		panel_3.add(DateText);
		
		PriceText = new JTextField();
		PriceText.setColumns(10);
		PriceText.setBounds(155, 121, 100, 20);
		panel_3.add(PriceText);
		
		PurchaseLabel = new JTextField();
		PurchaseLabel.setColumns(10);
		PurchaseLabel.setBounds(77, 174, 112, 20);
		panel_3.add(PurchaseLabel);
		
		JButton MakeSaleButton = new JButton("Make Sale");
		MakeSaleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int vehicleID, customerID, employeeID;
				String saleDate;
				double price;
				
				vehicleID = Integer.parseInt(SVText.getText());
				customerID = Integer.parseInt(SCText.getText());
				employeeID = Integer.parseInt(SEText.getText());
				saleDate = DateText.getText();
				price = Double.parseDouble(PriceText.getText());
				
				ds.sellCar(vehicleID, customerID, employeeID, saleDate, price);
			}
		});
		MakeSaleButton.setBounds(10, 279, 245, 23);
		panel_3.add(MakeSaleButton);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Filter Sales Table", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 627, 265, 245);
		dealershipWindow.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel EIDFilterLabel = new JLabel("Employee ID");
		EIDFilterLabel.setBounds(10, 21, 79, 14);
		panel_4.add(EIDFilterLabel);
		
		EIDFilterText = new JTextField();
		EIDFilterText.setBounds(155, 18, 100, 20);
		panel_4.add(EIDFilterText);
		EIDFilterText.setColumns(10);
		
		JButton EIDFilterButton = new JButton("Filter by Employee");
		EIDFilterButton.setBounds(10, 49, 244, 23);
		panel_4.add(EIDFilterButton);
		
		JButton SoldFilterButton = new JButton("Filter by Dealership buys");
		SoldFilterButton.setBounds(11, 92, 244, 23);
		panel_4.add(SoldFilterButton);
		
		JButton boughtFilterButton = new JButton("Filter by Dealership sells");
		boughtFilterButton.setBounds(11, 136, 244, 23);
		panel_4.add(boughtFilterButton);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(10, 178, 79, 14);
		panel_4.add(lblDate);
		
		DateFilterText = new JTextField();
		DateFilterText.setColumns(10);
		DateFilterText.setBounds(155, 175, 100, 20);
		panel_4.add(DateFilterText);
		
		JButton DateFilterButton = new JButton("Filter by Date");
		DateFilterButton.setBounds(10, 203, 244, 23);
		panel_4.add(DateFilterButton);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Filter Vehicles Table", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(285, 627, 265, 245);
		dealershipWindow.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel ColorFilterLabel = new JLabel("Color");
		ColorFilterLabel.setBounds(10, 27, 46, 14);
		panel_5.add(ColorFilterLabel);
		
		JLabel MakeFilterLabel = new JLabel("Make");
		MakeFilterLabel.setBounds(10, 52, 46, 14);
		panel_5.add(MakeFilterLabel);
		
		ColorFilterText = new JTextField();
		ColorFilterText.setBounds(155, 24, 100, 20);
		panel_5.add(ColorFilterText);
		ColorFilterText.setColumns(10);
		
		MakeFilterText = new JTextField();
		MakeFilterText.setColumns(10);
		MakeFilterText.setBounds(155, 49, 100, 20);
		panel_5.add(MakeFilterText);
		
		JButton VehicleFilterButton = new JButton("Filter Vehicles Table");
		VehicleFilterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String color, make;
				color = ColorFilterText.getText();
				make = MakeFilterText.getText();
				if(color.equals("")) {
					color = null;
				}
				if(make.equals("")) {
					make = null;
				}
				System.out.println(color);
				System.out.println(make);
				try {
					List<Vehicle> v1 = ds.getVehicles(make, color);
					v1.forEach(p -> {
						vehicle.addRow(new Object[] {p.getID(), p.getVin(), p.getMake(), p.getModel(), p.getYear(), p.getTrim(), p.getMSRP(), p.getColor(), p.getParkingStall(), 
								p.getOdometer(), p.isNew()});
					});
				}
				catch(Exception e2) {
					System.out.println(e2.toString());
				}
			}
		});
		VehicleFilterButton.setBounds(10, 77, 245, 23);
		panel_5.add(VehicleFilterButton);
		
		JButton OnPremisButton = new JButton("Show Vehicles at Dealership");
		OnPremisButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		OnPremisButton.setBounds(10, 111, 245, 23);
		panel_5.add(OnPremisButton);
		
		/**
		 * Button to clear vehicles table
		 * Keeps first row
		 */
		
		JButton ClearVehicles = new JButton("Clear Vehicles");
		ClearVehicles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vehicle.setRowCount(0);
				vehicle.addRow(new Object[] {"Vehicle ID", "VIN","Make", "Model", "Year", "Trim", "MSRP", "Color", "Parking Stall", "Odometer", "New"});
			}
		});
		ClearVehicles.setBounds(560, 627, 153, 23);
		dealershipWindow.getContentPane().add(ClearVehicles);
		
		/**
		 * Button to clear employees table
		 * Keeps first row
		 */
		
		JButton ClearEmployees = new JButton("Clear Employees");
		ClearEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employee.setRowCount(0);
				employee.addRow(new Object[] {"Employee ID", "First Name", "Last Name"});
			}
		});
		ClearEmployees.setBounds(559, 661, 154, 23);
		dealershipWindow.getContentPane().add(ClearEmployees);
		
		/**
		 * Button to clear sales table
		 * Keeps first row
		 */
		
		JButton ClearSales = new JButton("Clear Sales"); 
		ClearSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sales.setRowCount(0);
				sales.addRow(new Object[] {"Sale ID", "Vehicle ID", "Customer ID", "Employee ID", "Date", "Price", "Purchased"});
			}
		});
		ClearSales.setBounds(559, 700, 154, 23);
		dealershipWindow.getContentPane().add(ClearSales);
		
		/**
		 * Button to clear customers table
		 * Keeps first row
		 */
		
		JButton ClearCustomers = new JButton("Clear Customers");
		ClearCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer.setRowCount(0);
				customer.addRow(new Object[] {"Customer ID", "First Name", "Last Name", "Email", "Phone Number", "Address", "City", "Zip Code", "State"});
			}
		});
		ClearCustomers.setBounds(560, 734, 154, 23);
		dealershipWindow.getContentPane().add(ClearCustomers);
		
	}
}
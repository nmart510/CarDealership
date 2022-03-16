// This is the ONLY CLASS that connects with the database and runs SQL statements
// Running SQL statement is the SOLE PURPOSE of this class
// These methods are called by the Dealership class.
package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.java.Models.Customer;
import main.java.Models.Employee;
import main.java.Models.Sales;
import main.java.Models.Vehicle;

public class DBInteractions {
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	userInfo user = new userInfo();
	
	// main here is for TESTING. Remove main and its contents upon completion
	
	public static void main(String[] args) {
		//Attempted to see what was wrong with vehicles but wont even return a string
		
//		List<Vehicle> vh1 = new ArrayList<Vehicle>();
//		DBInteractions d = new DBInteractions();
//		
//		vh1 = d.getVehicles();
//		
//			System.out.print(vh1.toString() );
		
	}
	private java.sql.Date convertStringToDate(String date) {
		return java.sql.Date.valueOf(date);
	}
	public List<Employee> getEmployees() {
		List<Employee> el = new ArrayList<Employee>();
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(user.filepath, "postgres", user.password);
			
			String sql = "SELECT * FROM Employee";
			PreparedStatement statement = con.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				el.add(new Employee(rs.getInt("ID"), rs.getString("first_name"), rs.getString("last_name")));
			}
			return el;
		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}
		return null;
	}
	public List<Customer> getCustomers() {
		List<Customer> cl = new ArrayList<Customer>();
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(user.filepath, "postgres", user.password);
			
			String sql = "SELECT * FROM Customer";
			PreparedStatement statement = con.prepareStatement(sql);
			rs = statement.executeQuery();
			
			while (rs.next()) {
				cl.add(new Customer(rs.getInt("ID"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("phone"),
						rs.getString("address"), rs.getString("city"), rs.getString("zipcode"), rs.getString("state")));
			}
			return cl;
		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}
		return null;
	}
	public List<Vehicle> getVehicles() {
		System.out.println("Getting Vehicles");
		List<Vehicle> vl = new ArrayList<Vehicle>();
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(user.filepath, "postgres", user.password);
			
			String sql = "SELECT * FROM Vehicle";
			PreparedStatement statement = con.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				String[] mm = getMakeModel(rs.getInt("modelID"));
				System.out.println(mm[0] + "   " + mm[1] + "   " + mm[2]);
				
				vl.add(new Vehicle(rs.getInt("ID"), rs.getString("vin"), mm[1], mm[0], Integer.parseInt(mm[2]), rs.getString("trim"), rs.getDouble("msrp"), 
						rs.getString("color"), rs.getString("parkingstall"), rs.getInt("odometer"),rs.getBoolean("isnew")));
			}
			return vl;
		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}
		return null;
	}
	public List<Vehicle> getVehiclesByColor(String color) {
		System.out.println("Getting Vehicles By Color");
		List<Vehicle> vl = new ArrayList<Vehicle>();
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(user.filepath, "postgres", user.password);
			
			String sql = "SELECT * FROM Vehicle WHERE Color LIKE ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, color+"%");
			rs = statement.executeQuery();
			while (rs.next()) {
				String[] mm = getMakeModel(rs.getInt("modelID"));
				System.out.println(mm[0] + "   " + mm[1] + "   " + mm[2]);
				
				vl.add(new Vehicle(rs.getInt("ID"), rs.getString("vin"), mm[1], mm[0], Integer.parseInt(mm[2]), rs.getString("trim"), rs.getDouble("msrp"), 
						rs.getString("color"), rs.getString("parkingstall"), rs.getInt("odometer"),rs.getBoolean("isnew")));
			}
			return vl;
		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}
		return null;
	}
	public List<Vehicle> getVehiclesByMake(String Make) {
		System.out.println("Getting Vehicles By Make");
		List<Vehicle> vl = new ArrayList<Vehicle>();
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(user.filepath, "postgres", user.password);
			
			String sql = "SELECT * FROM Vehicle"
					+ "               JOIN Model ON (modelid =model.id)"
					+ "               JOIN Make ON (make.id = makeid)"
					+ "   WHERE Make.name LIKE ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, Make+"%");
			rs = statement.executeQuery();
			while (rs.next()) {
				String[] mm = getMakeModel(rs.getInt("modelID"));
				System.out.println(mm[0] + "   " + mm[1] + "   " + mm[2]);
				
				vl.add(new Vehicle(rs.getInt("ID"), rs.getString("vin"), mm[1], mm[0], Integer.parseInt(mm[2]), rs.getString("trim"), rs.getDouble("msrp"), 
						rs.getString("color"), rs.getString("parkingstall"), rs.getInt("odometer"),rs.getBoolean("isnew")));
			}
			return vl;
		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}
		return null;
	}
	public List<Vehicle> getVehiclesByMakeAndColor(String make, String color) {
		System.out.println("Getting Vehicles");
		List<Vehicle> vl = new ArrayList<Vehicle>();
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(user.filepath, "postgres", user.password);
			
			String sql = "SELECT * FROM Vehicle"
					+ "               JOIN Model ON (modelid = model.id)"
					+ "               JOIN Make ON (make.id = makeid)"
					+ "   WHERE (Make.name LIKE ?) AND (Color LIKE ?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, make+"%");
			statement.setString(2, color+"%");
			rs = statement.executeQuery();
			while (rs.next()) {
				String[] mm = getMakeModel(rs.getInt("modelID"));
				System.out.println(mm[0] + "   " + mm[1] + "   " + mm[2]);
				
				vl.add(new Vehicle(rs.getInt("ID"), rs.getString("vin"), mm[1], mm[0], Integer.parseInt(mm[2]), rs.getString("trim"), rs.getDouble("msrp"), 
						rs.getString("color"), rs.getString("parkingstall"), rs.getInt("odometer"),rs.getBoolean("isnew")));
			}
			return vl;
		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}
		return null;
	}
	public List<Sales> getSales() {
		List<Sales> sl = new ArrayList<Sales>();
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(user.filepath, "postgres", user.password);
			
			String sql = "SELECT * FROM Sale";
			PreparedStatement statement = con.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				sl.add(new Sales(rs.getInt("ID"), rs.getInt("vehicleID"), rs.getInt("customerID"), rs.getInt("employeeID"), rs.getString("date"), 
						rs.getDouble("price"), rs.getBoolean("dealerpurchase")));
			}
			return sl;
		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}
		return null;
	}
	public String[] getMakeModel(int modelID) {
		System.out.println("Getting Make and Model");
		try {
			String[] mm = new String[3];
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(user.filepath, "postgres", user.password);
			
			String sql = "SELECT * FROM Model WHERE ID = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, modelID);
			ResultSet rs1 = statement.executeQuery();
			rs1.next();
			mm[0] = rs1.getString("name");
			int makeID = rs1.getInt("makeID");
			mm[2] = rs1.getInt("year")+"";
			
			String sql2 = "SELECT * FROM Make WHERE ID = ?";
			PreparedStatement statement2 = con.prepareStatement(sql2);
			statement2.setInt(1, makeID);
			ResultSet rs2 = statement2.executeQuery();
			rs2.next();
			mm[1] = rs2.getString("name");
			return mm;
			
		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}
		return null;
	}
	public boolean createSale(int vId, int cId, int eId, String saleDate, double price, boolean purchase) {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(user.filepath, "postgres", user.password);
			
			String sql = "INSERT INTO Sale VALUES (nextval('Sale_id_seq'), "
					+ "                            ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, vId);
			statement.setInt(2, cId);
			statement.setInt(3, eId);
		    statement.setDate(4, convertStringToDate(saleDate));
		    statement.setDouble(5, price);
		    statement.setBoolean(6, purchase);
			statement.execute();
			return true;
		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}
		return false;
	}
	public boolean changeStall(int vId, String stall) {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(user.filepath, "postgres", user.password);
			
			String sql = "Update Vehicle SET ParkingStall = ? WHERE Vehicle.id = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, stall);
			statement.setInt(2, vId);
			return true;
		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}
		return false;
	}
	public int getModelIdOrAddMM(String makeName, String modelName, int year){
		System.out.println("Getting IDs for Make Model, or adding if non-existant");
		try { // Honestly, this goes against the layer system as the if/elses should be done in the Functional layer
			int makeid;
			con = DriverManager.getConnection(user.filepath, "postgres", user.password);
			String sql = "SELECT id FROM make WHERE make.name = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, makeName);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) { //If model exists, gets its ID
				makeid = rs.getInt("ID");
			} else {
				System.out.println("Make not found, adding");
				sql = "INSERT INTO Make VALUES (nextval('make_id_seq'), ?)";
				statement = con.prepareStatement(sql);
				statement.setString(1, makeName);
				statement.execute();
				System.out.println("Make not found INSERT debug");
				sql = "SELECT id FROM make WHERE make.name = ?";
				statement = con.prepareStatement(sql);
				statement.setString(1, makeName);
				rs = statement.executeQuery();
				rs.next();
				makeid = rs.getInt("ID");
			}
			System.out.println("Got MakeID: " + makeid);
			sql = "SELECT id FROM model WHERE name = ? AND year = ? AND makeid = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, modelName);
			statement.setInt(2, year);
			statement.setInt(3, makeid);
			rs = statement.executeQuery();
			int modelid;
			if (rs.next()) {
				modelid = rs.getInt("ID");
			} else {
				System.out.println("Model not found, adding");
				sql = "INSERT INTO Model VALUES (nextval('Model_id_seq'), ?, ?, ?)";
				statement = con.prepareStatement(sql);
				statement.setInt(1, year);
				statement.setInt(2, makeid);
				statement.setString(3, modelName);
				statement.execute();
				sql = "SELECT id FROM model WHERE name = ? AND year = ? AND makeid = ?";
				statement = con.prepareStatement(sql);
				statement.setString(1, modelName);
				statement.setInt(2, year);
				statement.setInt(3, makeid);
				rs = statement.executeQuery();
				rs.next();
				modelid = rs.getInt("ID");
			}
			System.out.println("Got ModelID: " + modelid);
			return modelid;
		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}
		return -1;
	}
	public boolean createVehicle(String VIN, int mID, String trim, double msrp, String color, String stall, int odometer, boolean isNew) {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(user.filepath, "postgres", user.password);
			
			String sql = "INSERT INTO Vehicle VALUES (nextval('vehicle_id_seq'), "
					+ "                            ?, ?, ?, ?, ?, ?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, VIN);
			statement.setInt(2, mID);
			statement.setString(3, trim);
		    statement.setDouble(4, msrp);
		    statement.setString(5, color);
		    statement.setString(6, stall);
		    statement.setInt(7, odometer);
		    statement.setBoolean(8, isNew);
			statement.execute();
			return true;
		}
		catch(Exception e1) {
			System.out.println("createVehicle exception: " + e1.toString());
		}
		return false;
	}
	public boolean createCustomer(String firstName, String lastName, String email, String phone, String address, String city, String zipcode, String state) {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(user.filepath, "postgres", user.password);
			
			String sql = "INSERT INTO Customer VALUES (nextval('customer_id_seq'), "
					+ "                            ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, email);
		    statement.setString(4, phone);
		    statement.setString(5, address);
		    statement.setString(6, city);
		    statement.setString(7, zipcode);
		    statement.setString(8, state);
			statement.execute();
			return true;
		}
		catch(Exception e1) {
			System.out.println("createCustomer exception: " + e1.toString());
		}
		return false;
	}
	public boolean createEmployee(String firstName, String lastName) {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(user.filepath, "postgres", user.password);
			
			String sql = "INSERT INTO Employee VALUES (nextval('Employee_id_seq'), "
					+ "                            ?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.execute();
			return true;
		}
		catch(Exception e1) {
			System.out.println("createEmployee exception: " + e1.toString());
		}
		return false;
	}
	public List<Sales> getSalesbyEmployee(int eID) {
		List<Sales> sl = new ArrayList<Sales>();
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(user.filepath, "postgres", user.password);
			
			String sql = "SELECT * FROM Sale WHERE employeeid = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, eID);
			rs = statement.executeQuery();
			while (rs.next()) {
				sl.add(new Sales(rs.getInt("ID"), rs.getInt("vehicleID"), rs.getInt("customerID"), rs.getInt("employeeID"), rs.getString("date"), 
						rs.getDouble("price"), rs.getBoolean("dealerpurchase")));
			}
			return sl;
		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}
		return null;
	}
	public List<Sales> getSalesByPurchase(boolean dealerPurchase) {
		List<Sales> sl = new ArrayList<Sales>();
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(user.filepath, "postgres", user.password);
			
			String sql = "SELECT * FROM Sale WHERE dealerpurchase = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setBoolean(1, dealerPurchase);
			rs = statement.executeQuery();
			while (rs.next()) {
				sl.add(new Sales(rs.getInt("ID"), rs.getInt("vehicleID"), rs.getInt("customerID"), rs.getInt("employeeID"), rs.getString("date"), 
						rs.getDouble("price"), rs.getBoolean("dealerpurchase")));
			}
			return sl;
		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}
		return null;
	}
	public List<Sales> getSalesByDate(String startDate, String endDate) {
		List<Sales> sl = new ArrayList<Sales>();
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(user.filepath, "postgres", user.password);
			
			String sql = "SELECT * FROM Sale WHERE date >= ? AND date <= ?";
			PreparedStatement statement = con.prepareStatement(sql);
			rs = statement.executeQuery();
			statement.setDate(1, convertStringToDate(startDate));
			statement.setDate(2, convertStringToDate(endDate));
			while (rs.next()) {
				sl.add(new Sales(rs.getInt("ID"), rs.getInt("vehicleID"), rs.getInt("customerID"), rs.getInt("employeeID"), rs.getString("date"), 
						rs.getDouble("price"), rs.getBoolean("dealerpurchase")));
			}
			return sl;
		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}
		return null;
	}
	
		
}

// This is the ONLY CLASS that connects with the database and runs SQL statements
// Running SQL statement is the SOLE PURPOSE of this class
// These methods are called by the Dealership class.
package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		/*
		List<Vehicle> vh1 = new ArrayList<Vehicle>();
		DBInteractions d = new DBInteractions();
		
		vh1 = d.getVehicles();
		
			System.out.print(vh1.toString());
		*/
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
		List<Vehicle> vl = new ArrayList<Vehicle>();
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(user.filepath, "postgres", user.password);
			
			String sql = "SELECT * FROM Vehicle";
			PreparedStatement statement = con.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				String[] mm = getMakeModel(rs.getInt("modelID"));
				vl.add(new Vehicle(rs.getInt("ID"), rs.getInt("vin"), mm[1], mm[0], Integer.parseInt(mm[2]), rs.getString("trim"), rs.getDouble("msrp"), 
						rs.getString("color"), rs.getInt("parkingstall"), rs.getInt("odometer"),rs.getBoolean("isnew")));
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
		try {
			String[] mm = new String[3];
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(user.filepath, "postgres", user.password);
			
			String sql = "SELECT * FROM Model WHERE ID = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, modelID);
			rs = statement.executeQuery();
			mm[0] = rs.getString("modelname");
			int makeID = rs.getInt("makeID");
			mm[2] = rs.getInt("year")+"";
			
			String sql2 = "SELECT * FROM Make WHERE ID = ?";
			PreparedStatement statement2 = con.prepareStatement(sql2);
			statement2.setInt(1, makeID);
			rs = statement2.executeQuery();
			mm[1] = rs.getString("name");
			return mm;
			
		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}
		return null;
	}
		
}

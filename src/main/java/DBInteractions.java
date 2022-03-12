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

import javax.swing.table.DefaultTableModel;

import main.java.Models.Employee;


public class DBInteractions {
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	userInfo user = new userInfo();
	
	// main here is for TESTING. Remove main and its contents upon completion
	
	public static void main(String[] args) {
		List<Employee> e = new ArrayList<Employee>();
		DBInteractions d = new DBInteractions();
		
		e = d.getEmployees();
		
			System.out.print(e.toString());
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
		
}

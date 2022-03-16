//This file will 
package main.java;

import java.util.List;

import main.java.Models.Customer;
import main.java.Models.Employee;
import main.java.Models.Sales;
import main.java.Models.Vehicle;

public class Dealership {
	DBInteractions dbi = new DBInteractions();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<Vehicle> getVehicles() {
		return dbi.getVehicles();
	}
	public List<Vehicle> getVehicles(String makeName, String color) {
		if (makeName == null)
			return dbi.getVehiclesByMakeAndColor("*", color);
		else if (color == null)
			return dbi.getVehiclesByMakeAndColor(makeName, "*");
		else
			return dbi.getVehiclesByMakeAndColor(makeName, color);
	}
	public boolean sellCar(int vehicleID, int customerID, int employeeID, String saleDate, double price) {
		boolean result = dbi.createSale(vehicleID, customerID, employeeID, saleDate, price, false);
		if (result)
			dbi.changeStall(vehicleID, "");
		return result;
	}
	public boolean buyCar(int vehicleID, int customerID, int employeeID, String saleDate, double price, String stall) {
		boolean result = dbi.createSale(vehicleID, customerID, employeeID, saleDate, price, true);
		if (result)
			dbi.changeStall(vehicleID, stall);
		return result;
	}
	public List<Sales> getSales() {
		return dbi.getSales();
	}
	public boolean addVehicle(int VIN, String makeName, String modelName, int year, String trim, double msrp, String color, String stall, int odometer, boolean isNew) {
		int mID = dbi.getModelIdOrAddMM(makeName, modelName, year);
		return dbi.createVehicle(VIN, mID, trim, msrp, color, stall, odometer, isNew);
	}
	public boolean addCustomer() {
		
		return false;
	}
	public boolean addEmployee() {
		
		return false;
	}
	public List<Employee> getEmployees(){
		return dbi.getEmployees();
	}
	public Employee getEmployeeByID(int ID) {
		
		return null;
	}
	public Employee getEmployeeByName(String name) {
		
		return null;
	}
	public List<Customer> getCustomers(){
		return dbi.getCustomers();
	}
	public Customer getCustomerByID(int ID) {
		
		return null;
	}
	public Customer getCustomerByName(String firstName, String lastName) {
		
		return null;
	}
	public boolean addMakeModel(String makeName, String modelName, int year) {
		return (dbi.getModelIdOrAddMM(makeName, modelName, year) > 0); 
	}
}

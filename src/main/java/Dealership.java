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
	public List<Vehicle> getDealerVehicles() {
		return dbi.getDealerVehicles();
	}
	public List<Vehicle> getVehicles(String makeName, String color) {
		if (makeName == null)
			return dbi.getVehiclesByColor(color);
		else if (color == null)
			return dbi.getVehiclesByMake(makeName);
		else
			return dbi.getVehiclesByMakeAndColor(makeName, color);
	}
	public boolean sellCar(int vehicleID, int customerID, int employeeID, String saleDate, double price) {
		if(dbi.getVehicleByID(vehicleID).getParkingStall().equals(""))
			return false;
		boolean result = dbi.createSale(vehicleID, customerID, employeeID, saleDate, price, false);
		if (result)
			dbi.changeStall(vehicleID, "");
		return result;
	}
	public boolean buyCar(int vehicleID, int customerID, int employeeID, String saleDate, double price, String stall) {
		if(dbi.getVehicleByID(vehicleID).getParkingStall().equals("") == false)
			return false;
		boolean result = dbi.createSale(vehicleID, customerID, employeeID, saleDate, price, true);
		if (result)
			dbi.changeStall(vehicleID, stall);
		return result;
	}
	public List<Sales> getSales() {
		return dbi.getSales();
	}
	public List<Sales> getSales(int eID) {
		return dbi.getSalesbyEmployee(eID);
	}
	public List<Sales> getSales(boolean dealerPurchase) {
		return dbi.getSalesByPurchase(dealerPurchase);
	}
	public List<Sales> getSales(String startDate, String endDate) {
		return dbi.getSalesByDate(startDate, endDate);
	}
	public boolean addVehicle(String VIN, String makeName, String modelName, int year, String trim, double msrp, String color, String stall, int odometer, boolean isNew) {
		int mID = dbi.getModelIdOrAddMM(makeName, modelName, year);
		return dbi.createVehicle(VIN, mID, trim, msrp, color, stall, odometer, isNew);
	}
	public boolean addCustomer(String firstName, String lastName, String email, String phone, String address, String city, String zipcode, String state) {
		return dbi.createCustomer(firstName, lastName, email, phone, address, city, zipcode, state);
	}
	public boolean addEmployee(String firstName, String lastName) {
		return dbi.createEmployee(firstName, lastName);
	}
	public List<Employee> getEmployees(){
		return dbi.getEmployees();
	}
	public List<Customer> getCustomers(){
		return dbi.getCustomers();
	}
	public boolean addMakeModel(String makeName, String modelName, int year) {
		return (dbi.getModelIdOrAddMM(makeName, modelName, year) > 0); 
	}
}

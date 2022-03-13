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
	boolean login(String fname, String lname, String pass){
		
		
		return false;
	}
	public List<Vehicle> getVehicles() {
		return dbi.getVehicles();
	} //Need to overload
	public boolean sellCar() {
		
		return false;
	}
	public boolean buyCar() {
		
		return false;
	}
	public List<Sales> getSales() {
		return dbi.getSales();
	}
	public boolean addVehicle() {
		
		return false;
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
	public Customer getCustomerByName(String name) {
		
		return null;
	}
	public boolean checkPassword(String pass) {
		
		return false;
	}
}

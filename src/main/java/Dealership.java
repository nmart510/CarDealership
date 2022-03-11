package main.java;

import java.util.List;

import main.java.Models.Customer;
import main.java.Models.Employee;
import main.java.Models.Sales;
import main.java.Models.Vehicle;

public class Dealership {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	boolean login(String fname, String lname, String pass){
		
		
		return false;
	}
	public List<Vehicle> viewCars() {
		
		
		return null;
	} //Need to overload
	public boolean sellCar() {
		
		return false;
	}
	public boolean buyCar() {
		
		return false;
	}
	public List<Sales> generateSalesHistory() {
		//Will need to make a Sales class for this and return an array of Sales.
		return null;
	} //Needs overloads
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
		
		return null;
	}
	public Employee getEmployeeByID(int ID) {
		
		return null;
	}
	public Employee getEmployeeByName(String name) {
		
		return null;
	}
	public List<Customer> getCustomers(){
		
		return null;
	}
	public Customer getCustomerByID(int ID) {
		
		return null;
	}
	public Customer getCustomerByName(String name) {
		
		return null;
	}
}

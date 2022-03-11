package main.java.Models;

public class Sales {
	int ID;
	int vehicleID;
	int customerID;
	int employeeID;
	String date;
	double price;
	boolean dealerPurchase;
	public Sales(int vehicleID, int customerID, int employeeID, String date, double price, boolean dealerPurchase) {
		super();
		this.vehicleID = vehicleID;
		this.customerID = customerID;
		this.employeeID = employeeID;
		this.date = date;
		this.price = price;
		this.dealerPurchase = dealerPurchase;
	}
	public Sales(int iD, int vehicleID, int customerID, int employeeID, String date, double price,
			boolean dealerPurchase) {
		super();
		ID = iD;
		this.vehicleID = vehicleID;
		this.customerID = customerID;
		this.employeeID = employeeID;
		this.date = date;
		this.price = price;
		this.dealerPurchase = dealerPurchase;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isDealerPurchase() {
		return dealerPurchase;
	}
	public void setDealerPurchase(boolean dealerPurchase) {
		this.dealerPurchase = dealerPurchase;
	}
	@Override
	public String toString() {
		return "Sales [ID=" + ID + ", vehicleID=" + vehicleID + ", customerID=" + customerID + ", employeeID="
				+ employeeID + ", date=" + date + ", price=" + price + ", dealerPurchase=" + dealerPurchase + "]";
	}
	
}

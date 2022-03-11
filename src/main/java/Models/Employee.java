package main.java.Models;

public class Employee {
	int ID;
	String first_name;
	String last_name;
	
	public Employee(String first_name, String last_name) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public Employee(int iD, String first_name, String last_name) {
		super();
		ID = iD;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Override
	public String toString() {
		return "Employee [ID=" + ID + ", first_name=" + first_name + ", last_name=" + last_name + "]";
	}
	
	
}

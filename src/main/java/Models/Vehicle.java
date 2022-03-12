package main.java.Models;

public class Vehicle {
	int ID;
	int vin;
	String make;
	String model;
	int year;
	String trim;
	double MSRP;
	String color;
	int parkingStall;
	int odometer;
	boolean isNew;
	
	public Vehicle(int vin, String make, String model, int year, String trim, double mSRP, String color, int parkingStall,
			int odometer, boolean isNew) {
		super();
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
		this.trim = trim;
		MSRP = mSRP;
		this.color = color;
		this.parkingStall = parkingStall;
		this.odometer = odometer;
		this.isNew = isNew;
	}

	public Vehicle(int iD, int vin, String make, String model, int year, String trim, double mSRP, String color,
			int parkingStall, int odometer, boolean isNew) {
		super();
		ID = iD;
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
		this.trim = trim;
		MSRP = mSRP;
		this.color = color;
		this.parkingStall = parkingStall;
		this.odometer = odometer;
		this.isNew = isNew;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getVin() {
		return vin;
	}

	public void setVin(int vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTrim() {
		return trim;
	}

	public void setTrim(String trim) {
		this.trim = trim;
	}

	public double getMSRP() {
		return MSRP;
	}

	public void setMSRP(double mSRP) {
		MSRP = mSRP;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getParkingStall() {
		return parkingStall;
	}

	public void setParkingStall(int parkingStall) {
		this.parkingStall = parkingStall;
	}


	public int getOdometer() {
		return odometer;
	}

	public void setOdometer(int odometer) {
		this.odometer = odometer;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	@Override
	public String toString() {
		return "Vehicle [ID=" + ID + ", VIN=" + vin + ", make=" + make + ", model=" + model + ", year=" + year + ", trim=" + trim
				+ ", MSRP=" + MSRP + ", color=" + color + ", parkingStall=" + parkingStall + ", odometer=" + odometer + ", isNew=" + isNew + "]";
	}
	
	
}

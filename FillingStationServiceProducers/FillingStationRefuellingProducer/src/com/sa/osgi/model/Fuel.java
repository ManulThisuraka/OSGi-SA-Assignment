package com.sa.osgi.model;

public class Fuel {
	
	private int fuelType; // 1 = Diesel, 2 = Petrol
	private int octane; // Normal & super diesel , Petrol 92,95
	private int capacityType; // 1 = Liters, 2 = Cash
	private int capacity; // Amount
	private double price; // Calculated price
	private float total;
	private double fuelPrice;
	
	private String fuelTypeString; //Fuel type base on fuelType int value
	private String fuelOctaneString; //Fuel octane based on int value of octane
	
	
	public Fuel(int fuelType, int octane, int capacityType, int capacity, float total, String fuelTypeString, String fuelOctaneString, double fuelPrice ) {
		super();
		this.fuelType = fuelType;
		this.octane = octane;
		this.capacityType = capacityType;
		this.capacity = capacity;
		this.total = total;
		this.fuelTypeString=fuelTypeString;
		this.fuelOctaneString=fuelOctaneString;
		this.fuelPrice=fuelPrice;
	}
	
	
	public double getFuelPrice() {
		return fuelPrice;
	}


	public void setFuelPrice(double fuelPrice) {
		this.fuelPrice = fuelPrice;
	}


	

	
	
	public String getFuelTypeString() {
		return fuelTypeString;
	}

	public void setFuelTypeString(String fuelTypeString) {
		this.fuelTypeString = fuelTypeString;
	}

	public String getFuelOctaneString() {
		return fuelOctaneString;
	}

	public void setFuelOctaneString(String fuelOctaneString) {
		this.fuelOctaneString = fuelOctaneString;
	}




	
	public double getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}

	
	
	public int getFuelType() {
		return fuelType;
	}

	public void setFuelType(int fuelType) {
		this.fuelType = fuelType;
	}

	public int getOctane() {
		return octane;
	}

	public void setOctane(int octane) {
		this.octane = octane;
	}

	public int getCapacityType() {
		return capacityType;
	}

	public void setCapacityType(int capacityType) {
		this.capacityType = capacityType;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

}




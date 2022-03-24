package com.sa.osgi.charge.model;

public class Charge {
	private int chargingCapacity; // 1 = 100%(full charging), 2 = 50%(half charging)
	private int chargingHr; // How many hours need 
	private double total;
	private double price;
	
	private String chargingTypeString; //charging type base on chargingCapacity int value
	
	
	public Charge(int chargingCapacity, int chargingHr,double total,double price, String chargingTypeString ) {
		super();
		this.chargingCapacity=chargingCapacity;
		this.chargingHr=chargingHr;
		this.total=total;
		this.price=price;
		this.chargingTypeString=chargingTypeString;
	}
	
	
	public int getChargingCapacity() {
		return chargingCapacity;
	}


	public void setChargingCapacity(int chargingCapacity) {
		this.chargingCapacity = chargingCapacity;
	}


	public int getChargingHr() {
		return chargingHr;
	}


	public void setChargingHr(int chargingHr) {
		this.chargingHr = chargingHr;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getChargingTypeString() {
		return chargingTypeString;
	}


	public void setChargingTypeString(String chargingTypeString) {
		this.chargingTypeString = chargingTypeString;
	}

}

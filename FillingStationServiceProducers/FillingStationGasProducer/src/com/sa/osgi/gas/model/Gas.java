package com.sa.osgi.gas.model;

public class Gas {
		
		private int gasTank; // 1 = 2.3KG, 2 = 5.0KG, 12.5KG
		private int quantity; // How many tanks need
		private double total;
		private double price;
		
		private String gasTankString; //Fuel type base on fuelType int value
		
		
		public Gas(int gasTank, int quantity,double total,double price, String gasTankString ) {
			super();
			this.gasTank=gasTank;
			this.quantity=quantity;
			this.total=total;
			this.price=price;
			this.gasTankString=gasTankString;
		}
		
		
		public int getGasTank() {
			return gasTank;
		}


		public void setGasTank(int gasTank) {
			this.gasTank = gasTank;
		}


		public int getQuantity() {
			return quantity;
		}


		public void setQuantity(int quantity) {
			this.quantity = quantity;
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


		public String getGasTankString() {
			return gasTankString;
		}


		public void setGasTankString(String gasTankString) {
			this.gasTankString = gasTankString;
		}


	}




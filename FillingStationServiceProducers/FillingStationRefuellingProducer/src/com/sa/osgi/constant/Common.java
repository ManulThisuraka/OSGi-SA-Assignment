package com.sa.osgi.constant;

public class Common {
	
	public static final int OPTION_NUMBER_DEFAULT_TEST = 0;
	public static final int ADD_FUEL_SUCCESS = 1;
	public static final int ADD_FUEL_NOT_ENOUGH_QUANTITY = -1;
	public static final int ADD_FUEL_NOT_FOUND = 0;
	
	public static final int OPTION_DIESEL = 1;
	public static final int OPTION_PETROL = 2;
	
	public static final int OPTION_LITERS = 1;
	public static final int OPTION_CASH = 2;
	
	public static final int DIESEL_NORMAL = 1;
	public static final int DIESEL_SUPER = 2;
	public static final int PETROL_92 = 1;
	public static final int PETROL_95 = 2;
	
	
	public static final String fuelType_Diesel = "Diesel";
	public static final String fuelType_Petrol = "Petrol";
	public static final String fuelOctane_Diesel_Normal = "Normal";
	public static final String fuelOctane_Diesel_Super = "Super";
	public static final String fuelOctane_Petrol_92 = "92 Octane";
	public static final String fuelOctane_Petrol_95 = "95 Octane";
	


	//Fuel Prices
	
	public static final double DIESEL_NORMAL_PRICE = 176.00;
	public static final double DIESEL_SUPER_PRICE = 254.00;
	
	public static final double PETROL_92_PRICE = 254.00;
	public static final double PETROL_95_PRICE = 283.00;
	
	
	// Services
	
	public static final int REFUELLING = 1;
	public static final int REFUELLING_HISTORY = 2;
	public static final int EXIT_SERVICE = 5;
	public static final int ERROR = 10;
	
}


package fillingstationrefuellingproducer;

import java.util.List;

import com.sa.osgi.constant.Common;
import com.sa.osgi.model.Fuel;
import com.sa.osgi.storage.stationStore;

public class FillingStationRefuellingServiceImpl implements FillingStationRefuellingService {

	double fuelPrice;
	public String fuelTypeString;
	public String fuelOctaneString;
	float Total = Common.OPTION_NUMBER_DEFAULT_TEST;
	
	
	

	@SuppressWarnings("unused")
	@Override
	public synchronized float addFuel(int fuelType, int octane, int capacityType, int capacity) { // Add fuel to data
		// storage and calculate
		// total
		// TODO Auto-generated method stub

		if (fuelType == Common.OPTION_DIESEL) {
			fuelTypeString= Common.fuelType_Diesel;
			if (octane == Common.DIESEL_NORMAL) {
				fuelOctaneString = Common.fuelOctane_Diesel_Normal;
				fuelPrice = Common.DIESEL_NORMAL_PRICE;
				if (capacityType == Common.OPTION_CASH) {
					Total = (float) (capacity / Common.DIESEL_NORMAL_PRICE);

				} else {
					Total = (float) (capacity * Common.DIESEL_NORMAL_PRICE);
				}

			} else {
				fuelPrice = Common.DIESEL_SUPER_PRICE;
				fuelOctaneString = Common.fuelOctane_Diesel_Super;
				if (capacityType == Common.OPTION_CASH) {
					Total = (float) (capacity / Common.DIESEL_SUPER_PRICE);
				} else {
					Total = (float) (capacity * Common.DIESEL_SUPER_PRICE);
				}
			}

		} else if (fuelType == Common.OPTION_PETROL) {
			fuelTypeString= Common.fuelType_Petrol;
			if (octane == Common.PETROL_92) {
				fuelPrice = Common.PETROL_92_PRICE;
				fuelOctaneString = Common.fuelOctane_Petrol_92;
				if (capacityType == Common.OPTION_CASH) {
					Total = (float) (capacity / Common.PETROL_92_PRICE);
				} else {
					Total = (float) (capacity * Common.PETROL_92_PRICE);
				}

			} else {
				fuelPrice = Common.PETROL_95_PRICE;
				fuelOctaneString = Common.fuelOctane_Petrol_95;
				if (capacityType == Common.OPTION_CASH) {
					Total = (float) (capacity / Common.PETROL_95_PRICE);
				} else {
					Total = (float) (capacity * Common.PETROL_95_PRICE);
				}
			}

		} else {
			System.out.println("Wrong Input !! Input Again.");
			return 0;

		}

		Fuel fuelRefill = new Fuel(fuelType, octane, capacityType, capacity, Total, fuelTypeString, fuelOctaneString, fuelPrice);
		stationStore.fuelAdd.add(fuelRefill);
		return Total;
	}

	@Override
	public List<Fuel> fuelHistory() { // return history of fuel 
		return stationStore.fuelAdd;
	}
}




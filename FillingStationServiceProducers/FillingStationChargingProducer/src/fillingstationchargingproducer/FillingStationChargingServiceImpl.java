package fillingstationchargingproducer;

import java.util.List;

import com.sa.osgi.charge.model.Charge;
import com.sa.osgi.chargeconstant.ChargeCommon;
import com.sa.osgi.chargingstorage.ChargeStore;


public class FillingStationChargingServiceImpl implements FillingStationChargingService {
	int chargingCapacity;
	int chargingHr;
	public String chargingTypeString;
	int Total = ChargeCommon.SELECTION_DEFAULT;
	double chargePrice;
	
	@SuppressWarnings("unused")
	@Override
	public synchronized int addCharge(int chargingCapacity, int chargingHr) { // Add charge data

		if (chargingCapacity == ChargeCommon.CHARGE_TYPE_FULL) {
			chargingTypeString = ChargeCommon.CHARGE_FULL;
			Total = (int) (ChargeCommon.CHARGE_FULL_PRICE * chargingHr);
			
			
		}else if(chargingCapacity == ChargeCommon.CHARGE_TYPE_HALF) {
			chargingTypeString = ChargeCommon.CHARGE_HALF;
			Total = (int) (ChargeCommon.CHARGE_HALF_PRICE * chargingHr);
			
		}else {
			System.out.println("Wrong Input !! Input Again.");
			return 0;
		}


		Charge buyCharge = new Charge(chargingCapacity,chargingHr,Total,chargePrice,chargingTypeString);
		ChargeStore.chargeBuy.add(buyCharge);
		return Total;
	}

	@Override
	public List<Charge> chargeHistory() { // return history of charge 
		return ChargeStore.chargeBuy;
	}
}

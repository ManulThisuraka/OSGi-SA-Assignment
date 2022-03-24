package fillingstationchargingproducer;

import java.util.List;

import com.sa.osgi.charge.model.Charge;



public interface FillingStationChargingService {
	public int addCharge(int chargingCapacity, int chargingHr);

	public List<Charge> chargeHistory();

}

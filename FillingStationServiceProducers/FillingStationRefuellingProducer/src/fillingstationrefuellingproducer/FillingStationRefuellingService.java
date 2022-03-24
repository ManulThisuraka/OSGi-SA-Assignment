package fillingstationrefuellingproducer;

import java.util.List;


import com.sa.osgi.model.Fuel;

public interface FillingStationRefuellingService {

	public float addFuel(int fuelType, int octane, int capacityType, int capacity);

	public List<Fuel> fuelHistory();

}

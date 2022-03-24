package fillingstationgasproducer;

import java.util.List;

import com.sa.osgi.gas.model.Gas;

public interface FillingStationGasService {

	public double buyGas(int gasTank, int quantity);
	public List<Gas> buyGas();


}

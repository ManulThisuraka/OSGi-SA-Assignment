package fillingstationgasproducer;

import com.sa.osgi.gas.model.Gas;
import com.sa.osgi.gasconstant.GasCommon;
import com.sa.osgi.gasstorage.Storage;
import java.util.List;



public class FillingStationGasServiceImpl implements FillingStationGasService {

	int gasTank;
	int quantity;
	public String gasTypeString;
	double Total;
	double gasPrice;
	
	@SuppressWarnings("unused")
	@Override
	public synchronized double buyGas(int gasTank, int quantity) { // Add gas data

		if (gasTank == GasCommon.TANK_TYPE_BUDDY) {
			gasTypeString = GasCommon.TANK_BUDDY;
			Total = GasCommon.TANK_BUDDY_PRICE * quantity;
			
			
		}else if(gasTank == GasCommon.TANK_TYPE_BUDGET) {
			gasTypeString = GasCommon.TANK_BUDGET;
			Total = GasCommon.TANK_BUDGET_PRICE * quantity;
			
		}else if(gasTank == GasCommon.TANK_TYPE_REGULAR) {
			gasTypeString = GasCommon.TANK_REGULAR;
			Total = GasCommon.TANK_REGULAR_PRICE * quantity;
			
		}else {
			System.out.println("Wrong Input !! Input Again.");
			return 0;
		}


		Gas buyGas = new Gas(gasTank,quantity,Total,gasPrice,gasTypeString);
		Storage.gasBuy.add(buyGas);
		return Total;
	}

	@Override
	public List<Gas> buyGas() { // return history of fuel 
		return Storage.gasBuy;
	}
	
}

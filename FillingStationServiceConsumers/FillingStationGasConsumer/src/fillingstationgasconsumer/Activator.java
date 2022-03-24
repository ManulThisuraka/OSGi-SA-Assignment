package fillingstationgasconsumer;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sa.osgi.gas.model.Gas;
import com.sa.osgi.gasconstant.GasCommon;

import fillingstationgasproducer.FillingStationGasService;


public class Activator implements BundleActivator {

	int gasType;
	int quantity;
	int selection;
	String gasTankString;
	static FillingStationGasService gasBuyServ;


	@SuppressWarnings("rawtypes")
	ServiceReference GasBuyServRef;
	Scanner scaninput = new Scanner(System.in);

	@SuppressWarnings("unchecked")
	public void start(BundleContext context) throws Exception {

		System.out.println("******************** Filling Station Gas Buying Consumer Started ********************");
		System.out.println("");

		GasBuyServRef = context.getServiceReference(FillingStationGasService.class.getName());
		gasBuyServ = (FillingStationGasService) context.getService(GasBuyServRef);


		System.out.println("******************** Welcome to Litro Gas Service ********************");
		System.out.println("");

		do {
			selection = GasCommon.SELECTION_DEFAULT;

			System.out.println("Please choose your option from below list or enter 5 or any key for exit.");
			System.out.println("");
			System.out.println("1.Buy a Gas");
			System.out.println("2.View Gas Brought History");
			System.out.println("5.Exit or any key");

			System.out.println("");
			System.out.print("Enter your option: ");

			try {
				selection = scaninput.nextInt();
			} catch (InputMismatchException e) {
				selection = 10;
			}


			if (selection == GasCommon.SELECTION_BUY_GAS) {

				System.out.println("*********************** Litro Gas Service **********************");
				System.out.println("");


				System.out.println("Enter Type of Gas Tank You Want: ");
				System.out.println("1.Buddy: ");
				System.out.println("2.Budget: ");
				System.out.println("3.Regular: ");
				
				try {
					gasType = scaninput.nextInt();
				} catch (InputMismatchException e) {
					selection = 10;
				}
				

				System.out.println("");
				
				try {
					System.out.print("Enter how many tanks you want: ");
					quantity = scaninput.nextInt();
				} catch (InputMismatchException e) {
					selection = 10;
				}


				switch(gasType) {
				case GasCommon.TANK_TYPE_BUDDY:
					gasTankString = GasCommon.TANK_BUDDY;
					break;
				case GasCommon.TANK_TYPE_BUDGET:
					gasTankString = GasCommon.TANK_BUDGET;
					break;
				case GasCommon.TANK_TYPE_REGULAR:
					gasTankString = GasCommon.TANK_REGULAR;
					break;
				}


				double total = gasBuyServ.buyGas(gasType, quantity);


				System.out.println("Your Total bill is : "+"Rs. "+total+"/-");
				System.out.println("Gas Supply Successfully! You will be redirect to home automatically!");

			}else if(selection == GasCommon.SELECTION_VIEW_GAS_HISTORY) {
				
				List<Gas> gasList = gasBuyServ.buyGas();

				if (gasList.size() == 0) {
					System.out.println("Gas Purchased History in database!");
					System.out.println("");
				} else {
					System.out.println("");
					System.out.println("Gas Tank" + "\t"+"\t" + "Quantity" + "\t" + "Total Price");

					for (Gas gas : gasList) {

						System.out.println(gas.getGasTankString() + "\t	"+"\t" + gas.getQuantity() + "\t	" + gas.getTotal());
					}

				}
				System.out.println("");
			}

		}while(selection != GasCommon.SELECTION_EXIT);{
			stop(context);
		}
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("******************** Filling Station Gas Supply Consumer Stopped ********************");
		context.ungetService(GasBuyServRef);
	}

}

package fillingstationchargingconsumer;

import java.util.InputMismatchException;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sa.osgi.charge.model.Charge;
import com.sa.osgi.chargeconstant.ChargeCommon;

import fillingstationchargingproducer.FillingStationChargingService;




public class Activator implements BundleActivator {
	int chargeType;
	int chargingHr;
	int selection;
	String chargingTypeString;
	static FillingStationChargingService chargeBuyServ;

	@SuppressWarnings("rawtypes")
	ServiceReference ChargeBuyServRef;
	Scanner scaninput = new Scanner(System.in);

	@SuppressWarnings("unchecked")
	public void start(BundleContext context) throws Exception {

		System.out.println("******************** Filling Station Charging Consumer Started ********************");
		System.out.println("");

		ChargeBuyServRef = context.getServiceReference(FillingStationChargingService.class.getName());
		chargeBuyServ = (FillingStationChargingService) context.getService(ChargeBuyServRef);


		System.out.println("******************** Welcome to Electrical Charging Center ********************");
		System.out.println("");

		do {
			selection = ChargeCommon.SELECTION_DEFAULT;

			System.out.println("Please choose your option from below list or enter 5 or any key for exit.");
			System.out.println("");
			System.out.println("1.Buy a Charging");
			System.out.println("2.View Charging History");
			System.out.println("5.Exit or any key");

			System.out.println("");
			System.out.print("Enter your option: ");

			try {
				selection = scaninput.nextInt();
			} catch (InputMismatchException e) {
				selection = 10;
			}


			if (selection == ChargeCommon.SELECTION_BUY_CHARGE) {

				System.out.println("*********************** Electrical Charging Service **********************");
				System.out.println("");


				System.out.println("Enter Type of Charging You Want: ");
				System.out.println("1.Full: ");
				System.out.println("2.Half: ");
				
				try {
					chargeType = scaninput.nextInt();
				} catch (InputMismatchException e) {
					selection = 10;
				}
				

				System.out.println("");
				
				try {
					System.out.print("Enter how many hours do you want to charge: ");
					chargingHr = scaninput.nextInt();
				} catch (InputMismatchException e) {
					selection = 10;
				}


				switch(chargeType) {
				case ChargeCommon.CHARGE_TYPE_FULL:
					chargingTypeString = ChargeCommon.CHARGE_FULL;
					break;
				case ChargeCommon.CHARGE_TYPE_HALF:
					chargingTypeString = ChargeCommon.CHARGE_HALF;
					break;
				}


				double total = chargeBuyServ.addCharge(chargeType, chargingHr);


				System.out.println("Your Total bill is : "+"Rs. "+total+"/-");
				System.out.println("Charged Successfully! You will be redirect to home automatically!");

			}else if(selection == ChargeCommon.SELECTION_VIEW_CHARGE_HISTORY) {
				
				List<Charge> chargeList = chargeBuyServ.chargeHistory();

				if (chargeList.size() == 0) {
					System.out.println("Charge Purchased History in database!");
					System.out.println("");
				} else {
					System.out.println("");
					System.out.println("Charging Type" + "\t"+"\t" + "Charging Hours" + "\t" + "Total Price");

					for (Charge charge : chargeList) {

						System.out.println(charge.getChargingTypeString() + "\t	"+"\t" + charge.getChargingHr() + "\t	" + charge.getTotal());
					}

				}
				System.out.println("");
			}

		}while(selection != ChargeCommon.SELECTION_EXIT);{
			stop(context);
		}
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("******************** Filling Station Electrical Charging Consumer Stopped ********************");
		context.ungetService(ChargeBuyServRef);
	}
}

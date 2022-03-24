package fillingstationrefuellingconsumer;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sa.osgi.constant.Common;
import com.sa.osgi.model.Fuel;

import fillingstationrefuellingproducer.FillingStationRefuellingService;


public class Activator implements BundleActivator {
	
	static FillingStationRefuellingService fuelAddServ;

	int octane;
	int refuelMethod;
	int capacity;
	int selection;
	int fuelType;
	String fuelTypeString;
	String fuelOctane;


	@SuppressWarnings("rawtypes")
	ServiceReference FuelAddServRef;
	Scanner scaninput = new Scanner(System.in);

	@SuppressWarnings("unchecked")
	public void start(BundleContext context) throws Exception {

		System.out.println("******************** Filling Station Refueling Consumer Started ********************");
		System.out.println("");

		FuelAddServRef = context.getServiceReference(FillingStationRefuellingService.class.getName());
		fuelAddServ = (FillingStationRefuellingService) context.getService(FuelAddServRef);


		System.out.println("******************** Welcome to Refueling Service ********************");
		System.out.println("");

		do {
			selection = Common.OPTION_NUMBER_DEFAULT_TEST;

			//		int selection = InputTypes.OPTION_NUMBER_DEFAULT;



			System.out.println("Please choose your option from below list or enter 5 or any key for exit.");
			System.out.println("");
			System.out.println("1.Refueling");
			System.out.println("2.View Fuel History");
			System.out.println("5.Exit or any key");

			System.out.println("");
			System.out.print("Enter your option: ");

			try {
				selection = scaninput.nextInt();
			} catch (InputMismatchException e) {
				selection = 10;
			}
			scaninput.nextLine();

			if (selection == Common.REFUELLING) {

				System.out.println("*********************** Fuel Refill **********************");
				System.out.println("");


				System.out.println("Enter Type of Fuel: ");
				System.out.println("1.Diesel: ");
				System.out.print("2.Petrol: ");
				fuelType = scaninput.nextInt();
				if(fuelType == 1) {

					System.out.println("1.Normal Diesel: ");
					System.out.println("2.Super Diesel: ");
					System.out.println("Enter Diesel Type: ");
					octane = scaninput.nextInt();
				}else {

					System.out.println("1.Ocatane 92: ");
					System.out.println("2.Ocatane 95: ");
					System.out.println("Enter Petrol Octane: ");
					octane = scaninput.nextInt();
				}

				System.out.println("Enter method you want to refuel: ");
				System.out.println("1.Liters ");
				System.out.println("2.Cash ");
				refuelMethod = scaninput.nextInt();
				if(refuelMethod == 1) {
					System.out.println("Enter how much liters you want: ");
					capacity = scaninput.nextInt();
				}else {
					System.out.println("Enter how much cash you got: ");
					capacity = scaninput.nextInt();
				}

				float tot = fuelAddServ.addFuel(fuelType, octane, refuelMethod, capacity);
				if (refuelMethod == 0) {
					System.out.println("Something went wrong! You will be redirect to home automatically!");
					System.out.println("");

				} else  {
					if(refuelMethod == Common.OPTION_CASH) {
						System.out.println("You have been refueled  : "+tot+ "Liters");
						System.out.println("Refueling Successfully! You will be redirect to home automatically!");

					}else {
						System.out.println("Your Total bill is : "+"Rs. "+tot+"/-");
						System.out.println("Refueling Successfully! You will be redirect to home automatically!");

					}
				}


			}else if(selection == Common.REFUELLING_HISTORY) {

				List<Fuel> fuelList = fuelAddServ.fuelHistory();

				if (fuelList.size() == 0) {
					System.out.println("Fuel History in database!");
					System.out.println("");
				} else {
					System.out.println("");
					System.out.println("Fuel Type" + "\t" + "Octane Type" + "\t" + "Fuel Price(1L)" + "\t"
							+ "Total Price/Liters");

					for (Fuel emp : fuelList) {

						System.out.println(emp.getFuelTypeString() + "\t	" + emp.getFuelOctaneString() + "\t	" + emp.getFuelPrice() + "\t	"
								+ emp.getTotal() );
					}

				}
				System.out.println("");

			}else {
				System.out.println("Something went wrong! You will be redirect to home automatically!");
				System.out.println("");
			}
		}while(selection != Common.EXIT_SERVICE);{
			stop(context);
		}


	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("******************** Filling Station Refueling Consumer Stopped ********************");
		context.ungetService(FuelAddServRef);
	}
}



package gui;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import fillingstationchargingproducer.FillingStationChargingService;
import fillingstationemployeeproducer.FillingStationEmployeeService;
import fillingstationgasproducer.FillingStationGasService;
import fillingstationrefuellingproducer.FillingStationRefuellingService;

public class Activator implements BundleActivator {

	ServiceReference EmployeeManagerServRef;
	
	static FillingStationEmployeeService fillstaempserv;
	static FillingStationRefuellingService fillFuelServ;
	static FillingStationGasService fillstagasserv;
	static FillingStationChargingService fillstachargeserv;
	
	public static ServiceTracker EmpServTrack;
	public static ServiceTracker FuelServTrack;
	public static ServiceTracker GasServTrack;
	public static ServiceTracker ChargeServTrack;

	public void start(BundleContext context) throws Exception {

		// Show MenuGUI frame
		MenuGui frame = new MenuGui();
		frame.setVisible(true);

		// Get Employee Service from Employee Producer
		EmpServTrack = new ServiceTracker(context, FillingStationEmployeeService.class.getName(), null);
		FuelServTrack = new ServiceTracker(context, FillingStationRefuellingService.class.getName(), null);
		GasServTrack = new ServiceTracker(context, FillingStationGasService.class.getName(), null);
		ChargeServTrack = new ServiceTracker(context, FillingStationChargingService.class.getName(), null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Converter service is stopped");
	}

	// Track Employee Service
	public static boolean EmployeeServiceChecker() {
		EmpServTrack.open();
		fillstaempserv = (FillingStationEmployeeService) EmpServTrack.getService();

		if (fillstaempserv != null)
			return true;
		else
			return false;
	}
	
	// Track Refilling Service
		public static boolean FueleServiceChecker() {
			FuelServTrack.open();
			fillFuelServ = (FillingStationRefuellingService) FuelServTrack.getService();

			if (fillFuelServ != null)
				return true;
			else
				return false;
		}
		
	// Track Gas Service
				public static boolean GasServiceChecker() {
					GasServTrack.open();
					fillstagasserv = (FillingStationGasService) GasServTrack.getService();

					if (fillstagasserv != null)
						return true;
					else
						return false;
				}
				
	// Track Gas Service
				public static boolean ChargeServiceChecker() {
					ChargeServTrack.open();
					fillstachargeserv = (FillingStationChargingService) ChargeServTrack.getService();

					if (fillstachargeserv != null)
						return true;
					else
						return false;
				}

}

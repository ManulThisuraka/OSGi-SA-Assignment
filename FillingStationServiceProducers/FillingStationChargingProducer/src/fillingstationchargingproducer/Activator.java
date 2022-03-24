package fillingstationchargingproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class Activator implements BundleActivator {
	
	ServiceRegistration serviceRegisterer;
	
	
	public void start(BundleContext context) throws Exception {
		System.out.println("************** Charging Service Started **************");
		FillingStationChargingService fillingStationRefuellingService = new FillingStationChargingServiceImpl();
		serviceRegisterer = context.registerService(FillingStationChargingService.class.getName(), fillingStationRefuellingService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("************** Charging Service Stopped **************");
		serviceRegisterer.unregister();
	}

}

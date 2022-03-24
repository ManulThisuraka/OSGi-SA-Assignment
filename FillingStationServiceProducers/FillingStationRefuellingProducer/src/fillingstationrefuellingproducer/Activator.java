package fillingstationrefuellingproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {

	ServiceRegistration serviceRegisterer;

	public void start(BundleContext context) throws Exception {
		
		System.out.println("************** Refuelling Service Started **************");
		
		FillingStationRefuellingService fillingStationRefuellingService = new FillingStationRefuellingServiceImpl();
		serviceRegisterer = context.registerService(FillingStationRefuellingService.class.getName(), fillingStationRefuellingService, null);
		
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("************** Refuelling Service Stopped **************");
		serviceRegisterer.unregister();
	}

}

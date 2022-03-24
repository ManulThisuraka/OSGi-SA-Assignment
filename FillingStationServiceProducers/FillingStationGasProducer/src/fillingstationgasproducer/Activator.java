package fillingstationgasproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegisterer;

	

	public void start(BundleContext context) throws Exception {
		System.out.println("************** Gas Buying Service Started **************");
		FillingStationGasService fillingStationRefuellingService = new FillingStationGasServiceImpl();
		serviceRegisterer = context.registerService(FillingStationGasService.class.getName(), fillingStationRefuellingService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("************** Gas Buying Service Stopped **************");
		serviceRegisterer.unregister();
	}

}

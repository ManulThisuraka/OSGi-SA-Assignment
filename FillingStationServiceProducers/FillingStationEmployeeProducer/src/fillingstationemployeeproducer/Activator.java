package fillingstationemployeeproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegisterer;

	public void start(BundleContext context) throws Exception {
		System.out.println("************** Filling Station Employee Service Started **************");
		// Register Employee service
		FillingStationEmployeeService fillstaempserv = new FillingStationEmployeeServiceImpl();
		serviceRegisterer = context.registerService(FillingStationEmployeeService.class.getName(), fillstaempserv,
				null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("************** Filling Station Employee Service Stopped **************");
		serviceRegisterer.unregister();
	}

}

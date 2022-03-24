package fillingstationemployeeconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import fillingstationemployeeproducer.FillingStationEmployeeService;

public class Activator implements BundleActivator {

	ServiceReference EmployeeManagerServRef;
	static FillingStationEmployeeService fillstaempserv;

	public void start(BundleContext context) throws Exception {
		System.out.println("********** Filling Station Employee Consumer Started **********");
		System.out.println("");

		// Get Employee Service from Employee producer
		EmployeeManagerServRef = context.getServiceReference(FillingStationEmployeeService.class.getName());
		fillstaempserv = (FillingStationEmployeeService) context.getService(EmployeeManagerServRef);

		// Start CLI Service
		fillstaempserv.EmployeeService();

	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("********** Filling Station Employee Consumer Stopped **********");
		context.ungetService(EmployeeManagerServRef);

	}

}

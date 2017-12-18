package plugin1;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.format("Bundle %s started.%n", context.getBundle().getSymbolicName());
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.format("Bundle %s stopped.%n", context.getBundle().getSymbolicName());
	}

}

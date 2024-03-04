package de.mbg.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class StartRMIServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create and install a security manager
		// System.setProperty("java.security.policy", "file://C:/verteilte-systeme/src/verteilte_systeme_rmi/src/policy");

		try {
			int registryPort = 2002;
			System.out.println("Create registry on port: " + registryPort);
			Registry registry = LocateRegistry.createRegistry(registryPort);

			// Create object that should be accessable
			CalculatorImpl obj = new CalculatorImpl();

			// Export remote object
			CalculatorInterface stub = (CalculatorInterface) UnicastRemoteObject.exportObject(obj, 0);

			// Bind this object instance to the name "Calculator"
			registry.rebind("Calculator", stub);

			System.out.println("CalculatorImpl bound in registry");
		} catch (Exception e) {
			System.out.println("StartRMIServer err: " + e.getMessage());
			e.printStackTrace();
		}

	}

}

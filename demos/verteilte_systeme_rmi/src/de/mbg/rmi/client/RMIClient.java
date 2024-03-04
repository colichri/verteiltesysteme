package de.mbg.rmi.client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

import de.mbg.rmi.CalculatorInterface;

public class RMIClient {

	/**
	 * @param args
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

		// Zugriff auf die Registry
		Registry registry = LocateRegistry.getRegistry("localhost", 2002);

		// Referenz auf die Instanz ueber Interface und Stub...
		CalculatorInterface testServer = (CalculatorInterface) registry.lookup("Calculator");

		// Aufruf der entfernten Methode...
		int x = 2;
		int y = 3;

		int value = testServer.add(x, y);
		System.out.println("RMIClient.main: " + x + " + " + y + " = " + value);

		value = testServer.subtract(x, y);
		System.out.println("RMIClient.main: " + x + " - " + y + " = " + value);

		Date currentDate = testServer.getCurrentDate();
		System.out.println("RMIClient.main: " + currentDate);
	}

}

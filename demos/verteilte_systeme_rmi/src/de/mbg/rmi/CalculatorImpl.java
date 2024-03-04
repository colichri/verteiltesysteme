package de.mbg.rmi;

import java.rmi.RemoteException;
import java.util.Date;

public class CalculatorImpl implements CalculatorInterface {

	public CalculatorImpl() throws RemoteException {
	}

	public int add(int x, int y) throws RemoteException {
		int value = x + y;
		System.out.println("CalculatorImpl.add: " + x + " + " + y + " = "
				+ value);
		return value;
	}

	public int subtract(int x, int y) throws RemoteException {
		int value = x - y;
		System.out.println("CalculatorImpl.subtract: " + x + " - " + y + " = "
				+ value);
		return value;
	}

	public Date getCurrentDate() throws RemoteException {
		Date currentDate = new Date();
		System.out.println("CalculatorImpl.getCurrentDate: " + currentDate);
		return currentDate;
	}

}

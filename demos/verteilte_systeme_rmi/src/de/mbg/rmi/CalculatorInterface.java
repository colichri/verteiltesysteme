package de.mbg.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface CalculatorInterface extends Remote {

	public int add(int x, int y) throws RemoteException;

	public int subtract(int x, int y) throws RemoteException;

	public Date getCurrentDate() throws RemoteException;
}

package de.mbg.jee.simple;

import javax.ejb.Remote;

@Remote
public interface CalculatorServiceRemote {

	public int add(int x, int y);

	public int subtract(int x, int y);

	public int multiply(int x, int y);

}

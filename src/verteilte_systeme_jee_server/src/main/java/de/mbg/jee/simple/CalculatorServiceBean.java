package de.mbg.jee.simple;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateless
@WebService
public class CalculatorServiceBean implements CalculatorServiceRemote {

	@WebMethod
	public int add(int x, int y) {
		int z = x + y;
		System.out.println("CalculatorServiceBean.add: " + x + " + " + y + " = " + z);
		return z;
	}

	@WebMethod
	public int subtract(int x, int y) {
		int z = x - y;
		System.out.println("CalculatorServiceBean.subtract: " + x + " - " + y + " = " + z);
		return z;
	}

	@WebMethod
	public int multiply(int x, int y) {
		int z = x * y;
		System.out.println("CalculatorServiceBean.multiply: " + x + " * " + y + " = " + z);
		return z;
	}
}

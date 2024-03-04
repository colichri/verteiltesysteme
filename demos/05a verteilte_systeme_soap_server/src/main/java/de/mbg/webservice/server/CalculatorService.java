package de.mbg.webservice.server;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public class CalculatorService {

	public int add(@WebParam(name = "x") int x, @WebParam(name = "y") int y) {
		int sum = x + y;
		System.out.println("Adding: " + x + " + " + y + " = " + sum);
		return sum;
	}

	public double divide(@WebParam(name = "zaehler") int x, @WebParam(name = "devisor") int y) {
		if (y == 0) {
			throw new ArithmeticException("Division by 0");
		}
		double result = ((double) x) / y;
		System.out.println("divide = " + x + "/" + y + " = " + result);
		return result;
	}

	public User getExampleUser() {
		User user = new User();
		user.setShortName("dduck");
		user.setFirstName("Donald");
		user.setLastName("Duck");
		System.out.println("User = " + user);
		return user;
	}

}

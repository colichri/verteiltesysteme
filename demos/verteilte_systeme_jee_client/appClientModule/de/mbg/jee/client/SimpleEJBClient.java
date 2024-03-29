package de.mbg.jee.client;

import javax.naming.InitialContext;

import de.mbg.jee.simple.CalculatorServiceRemote;

public class SimpleEJBClient {
	public static void main(String[] args) throws Exception {
		String jndiName = "04a_verteilte_systeme_jee_server/CalculatorServiceBean!de.mbg.jee.simple.CalculatorServiceRemote";
		InitialContext ctx = new InitialContext();
		CalculatorServiceRemote calculator = (CalculatorServiceRemote) ctx.lookup(jndiName);
		int x = 1;
		int y = 2;
		int sum = calculator.add(x, y);

		System.out.println("Result: " + x + " + " + y + " = " + sum);
	}

}
package de.mbg.webservice.client;

import de.mbg.webservice.client.gen.CalculatorService;
import de.mbg.webservice.client.gen.CalculatorServiceService;
import de.mbg.webservice.client.gen.User;

public class SoapClientMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Make use of generated code...
		CalculatorServiceService service = new CalculatorServiceService();
		CalculatorService calculator = service.getCalculatorServicePort();
		int x = 3;
		int y = 74;

		int result = calculator.add(x, y);
		System.out.println("Add " + x + " to " + y + " = " + result);

		double div = calculator.divide(y, x);
		System.out.println("Divide " + x + " to " + y + " = " + div);

		User user = calculator.getExampleUser();
		System.out.println("User = " + user.getShortName());
	}
}
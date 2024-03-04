package de.mbg.webservice.server;

import jakarta.xml.ws.Endpoint;

public class WebServiceServer {

	public static void main(String[] args) {
		String url = "http://localhost:8090";
		CalculatorService service = new CalculatorService();

		String calculatorURL = url + "/calculator";

		Endpoint endpoint = Endpoint.publish(calculatorURL, service);
		System.out.println("Server is running... " + url);
		System.out.println("Calculator WSDL=" + calculatorURL + "?wsdl");
	}
}

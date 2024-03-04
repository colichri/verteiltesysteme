
package de.mbg.webservice.client.gen;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 * 
 */
@WebService(name = "CalculatorService", targetNamespace = "http://server.webservice.mbg.de/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CalculatorService {


    /**
     * 
     * @param x
     * @param y
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "add", targetNamespace = "http://server.webservice.mbg.de/", className = "de.mbg.webservice.client.gen.Add")
    @ResponseWrapper(localName = "addResponse", targetNamespace = "http://server.webservice.mbg.de/", className = "de.mbg.webservice.client.gen.AddResponse")
    @Action(input = "http://server.webservice.mbg.de/CalculatorService/addRequest", output = "http://server.webservice.mbg.de/CalculatorService/addResponse")
    public int add(
        @WebParam(name = "x", targetNamespace = "")
        int x,
        @WebParam(name = "y", targetNamespace = "")
        int y);

    /**
     * 
     * @return
     *     returns de.mbg.webservice.client.gen.User
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getExampleUser", targetNamespace = "http://server.webservice.mbg.de/", className = "de.mbg.webservice.client.gen.GetExampleUser")
    @ResponseWrapper(localName = "getExampleUserResponse", targetNamespace = "http://server.webservice.mbg.de/", className = "de.mbg.webservice.client.gen.GetExampleUserResponse")
    @Action(input = "http://server.webservice.mbg.de/CalculatorService/getExampleUserRequest", output = "http://server.webservice.mbg.de/CalculatorService/getExampleUserResponse")
    public User getExampleUser();

    /**
     * 
     * @param devisor
     * @param zaehler
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "divide", targetNamespace = "http://server.webservice.mbg.de/", className = "de.mbg.webservice.client.gen.Divide")
    @ResponseWrapper(localName = "divideResponse", targetNamespace = "http://server.webservice.mbg.de/", className = "de.mbg.webservice.client.gen.DivideResponse")
    @Action(input = "http://server.webservice.mbg.de/CalculatorService/divideRequest", output = "http://server.webservice.mbg.de/CalculatorService/divideResponse")
    public double divide(
        @WebParam(name = "zaehler", targetNamespace = "")
        int zaehler,
        @WebParam(name = "devisor", targetNamespace = "")
        int devisor);

}

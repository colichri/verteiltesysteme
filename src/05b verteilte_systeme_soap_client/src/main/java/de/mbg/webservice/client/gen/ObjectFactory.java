
package de.mbg.webservice.client.gen;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.mbg.webservice.client.gen package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private static final QName _Add_QNAME = new QName("http://server.webservice.mbg.de/", "add");
    private static final QName _AddResponse_QNAME = new QName("http://server.webservice.mbg.de/", "addResponse");
    private static final QName _Divide_QNAME = new QName("http://server.webservice.mbg.de/", "divide");
    private static final QName _DivideResponse_QNAME = new QName("http://server.webservice.mbg.de/", "divideResponse");
    private static final QName _GetExampleUser_QNAME = new QName("http://server.webservice.mbg.de/", "getExampleUser");
    private static final QName _GetExampleUserResponse_QNAME = new QName("http://server.webservice.mbg.de/", "getExampleUserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.mbg.webservice.client.gen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Add }
     * 
     * @return
     *     the new instance of {@link Add }
     */
    public Add createAdd() {
        return new Add();
    }

    /**
     * Create an instance of {@link AddResponse }
     * 
     * @return
     *     the new instance of {@link AddResponse }
     */
    public AddResponse createAddResponse() {
        return new AddResponse();
    }

    /**
     * Create an instance of {@link Divide }
     * 
     * @return
     *     the new instance of {@link Divide }
     */
    public Divide createDivide() {
        return new Divide();
    }

    /**
     * Create an instance of {@link DivideResponse }
     * 
     * @return
     *     the new instance of {@link DivideResponse }
     */
    public DivideResponse createDivideResponse() {
        return new DivideResponse();
    }

    /**
     * Create an instance of {@link GetExampleUser }
     * 
     * @return
     *     the new instance of {@link GetExampleUser }
     */
    public GetExampleUser createGetExampleUser() {
        return new GetExampleUser();
    }

    /**
     * Create an instance of {@link GetExampleUserResponse }
     * 
     * @return
     *     the new instance of {@link GetExampleUserResponse }
     */
    public GetExampleUserResponse createGetExampleUserResponse() {
        return new GetExampleUserResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     * @return
     *     the new instance of {@link User }
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Add }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Add }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.webservice.mbg.de/", name = "add")
    public JAXBElement<Add> createAdd(Add value) {
        return new JAXBElement<>(_Add_QNAME, Add.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.webservice.mbg.de/", name = "addResponse")
    public JAXBElement<AddResponse> createAddResponse(AddResponse value) {
        return new JAXBElement<>(_AddResponse_QNAME, AddResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Divide }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Divide }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.webservice.mbg.de/", name = "divide")
    public JAXBElement<Divide> createDivide(Divide value) {
        return new JAXBElement<>(_Divide_QNAME, Divide.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DivideResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DivideResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.webservice.mbg.de/", name = "divideResponse")
    public JAXBElement<DivideResponse> createDivideResponse(DivideResponse value) {
        return new JAXBElement<>(_DivideResponse_QNAME, DivideResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExampleUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetExampleUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.webservice.mbg.de/", name = "getExampleUser")
    public JAXBElement<GetExampleUser> createGetExampleUser(GetExampleUser value) {
        return new JAXBElement<>(_GetExampleUser_QNAME, GetExampleUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExampleUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetExampleUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.webservice.mbg.de/", name = "getExampleUserResponse")
    public JAXBElement<GetExampleUserResponse> createGetExampleUserResponse(GetExampleUserResponse value) {
        return new JAXBElement<>(_GetExampleUserResponse_QNAME, GetExampleUserResponse.class, null, value);
    }

}

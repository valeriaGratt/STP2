
package org.donstu.async;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.donstu.async package. 
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

    private final static QName _GetDogs_QNAME = new QName("https://donstu.org/cynology", "getDogs");
    private final static QName _GetDogsResponse_QNAME = new QName("https://donstu.org/cynology", "getDogsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.donstu.async
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDogsResponse }
     * 
     */
    public GetDogsResponse createGetDogsResponse() {
        return new GetDogsResponse();
    }

    /**
     * Create an instance of {@link GetDogs }
     * 
     */
    public GetDogs createGetDogs() {
        return new GetDogs();
    }

    /**
     * Create an instance of {@link Dog }
     * 
     */
    public Dog createDog() {
        return new Dog();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDogs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://donstu.org/cynology", name = "getDogs")
    public JAXBElement<GetDogs> createGetDogs(GetDogs value) {
        return new JAXBElement<GetDogs>(_GetDogs_QNAME, GetDogs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDogsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://donstu.org/cynology", name = "getDogsResponse")
    public JAXBElement<GetDogsResponse> createGetDogsResponse(GetDogsResponse value) {
        return new JAXBElement<GetDogsResponse>(_GetDogsResponse_QNAME, GetDogsResponse.class, null, value);
    }

}

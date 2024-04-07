package org.donstu.service;

import org.donstu.domain.Dog;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

import static javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED;
import static javax.jws.soap.SOAPBinding.Style.DOCUMENT;
import static javax.jws.soap.SOAPBinding.Use.LITERAL;

@WebService(serviceName = "CynologyService", portName = "CynologyPort",
    targetNamespace = "https://donstu.org/cynology")
@SOAPBinding(style = DOCUMENT, use = LITERAL, parameterStyle = WRAPPED)
public class CynologyService {

    @WebMethod(operationName = "getDogs")
    public List<Dog> getDogs() {
        List<Dog> result = new ArrayList<>();
        result.add(new Dog("Sally", 1, "Border Collie"));
        result.add(new Dog("Max", 2, "Husky"));
        result.add(new Dog("Charlie", 3, "German Shepherd"));
        result.add(new Dog("Lucy", 4, "Chow-Chow"));
        result.add(new Dog("Oscar", 5, "Poodle"));
        result.add(new Dog("Buddy", 6, "Beagle"));
        return result;
    }
}

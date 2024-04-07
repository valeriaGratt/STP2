package org.donstu;

import org.donstu.client.CynologyService;
import org.donstu.client.CynologyService_Service;
import org.donstu.client.Dog;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ServiceClient {
    private static final QName FQDN = new QName("https://donstu.org/cynology", "CynologyService");

    private static URL getWsdlUrl(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return url;
    }

    public void processDogs(URL url) {
        CynologyService_Service svc = new CynologyService_Service(url, FQDN);
        CynologyService port = svc.getCynologyPort();
        List<Dog> dogs = port.getDogs();
        dogs.forEach(dog -> System.out.println("Dog{" +
                "name='" + dog.getName() + '\'' +
                ", age=" + dog.getAge() +
                ", breed='" + dog.getBreed() + '\'' +
                '}'));
    }

    public static void main(String[] args) {
        URL wsdlUrl = getWsdlUrl("http://127.0.0.1:8088/cynology?wsdl");
        ServiceClient client = new ServiceClient();
        client.processDogs(wsdlUrl);
    }
}

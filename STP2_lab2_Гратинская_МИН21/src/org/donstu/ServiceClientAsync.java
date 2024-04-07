package org.donstu;

import org.donstu.async.CynologyService;
import org.donstu.async.CynologyService_Service;
import org.donstu.async.GetDogsResponse;
import org.donstu.async.Dog;

import javax.xml.namespace.QName;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ServiceClientAsync {
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
        Response<GetDogsResponse> response = port.getDogsAsync();
        while (!response.isDone()) {
            System.out.println("Pooling the result...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            List<Dog> dogs = response.get().getReturn();
            dogs.forEach(dog -> System.out.println("Dog{" +
                    "name='" + dog.getName() + '\'' +
                    ", age=" + dog.getAge() +
                    ", breed='" + dog.getBreed() + '\'' +
                    '}'));
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    class CynologyAsyncHandler implements AsyncHandler<GetDogsResponse> {
        private GetDogsResponse response;

        @Override
        public void handleResponse(Response<GetDogsResponse> res) {
            System.out.println("Result is ready!");
            try {
                response = res.get();
                List<Dog> dogs = response.getReturn();
                dogs.forEach(dog -> System.out.println("Dog{" +
                        "name='" + dog.getName() + '\'' +
                        ", age=" + dog.getAge() +
                        ", breed='" + dog.getBreed() + '\'' +
                        '}'));
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void processDogsCallback(URL url) {
        CynologyService_Service svc = new CynologyService_Service(url, FQDN);
        CynologyService port = svc.getCynologyPort();
        CynologyAsyncHandler handler = new CynologyAsyncHandler();
        Future<?> response = port.getDogsAsync(handler);
        try {
            Thread.sleep(5000);
            System.out.println("Waited 5s");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        URL wsdlUrl = getWsdlUrl("http://127.0.0.1:8088/cynology?wsdl");
        ServiceClientAsync client = new ServiceClientAsync();
        client.processDogs(wsdlUrl);
        client.processDogsCallback(wsdlUrl);
    }
}

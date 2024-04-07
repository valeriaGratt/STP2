package org.dstu.bpm;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;


@Component
@ExternalTaskSubscription("update-dog")
public class UdateDogHandler implements ExternalTaskHandler {
    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        Logger.getLogger("update-dog").log(Level.INFO, "Updating good boy info...");

//        RestTemplate rt = new RestTemplate();
//        Object response = rt.postForObject("http://localhost:8082/JavaRest/rest/dog/update/0", null, Object.class);
//        System.out.println(response);

        externalTaskService.complete(externalTask);
    }
}

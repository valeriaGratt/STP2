package org.dstu.bpm;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@ExternalTaskSubscription("check-dog")
public class CheckDogHandler implements ExternalTaskHandler {

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        Map<String, Object> vars = new LinkedHashMap<>();
        vars.put("dogAvailable", true);

        //RestTemplate rt = new RestTemplate();
        //Object response = rt.getForObject("http://localhost:8082/JavaRest/rest/dog/0", Object.class);
        //System.out.println(response);

        Logger.getLogger("check-dog").log(Level.INFO, "Looking for a GOOOOD BOY");
        externalTaskService.complete(externalTask, vars);
    }
}

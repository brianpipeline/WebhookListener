package com.brianpipeline.webhooklistener.github;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.outbound.PubSubMessageHandler;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class GithubController {

    private final PubSubTemplate pubSubTemplate;
    private final Gson gson;
    public GithubController(PubSubTemplate pubSubTemplate) {
        this.pubSubTemplate = pubSubTemplate;
        gson = new Gson();
    }

    @PostMapping("/github-webhook")
    ResponseEntity<Void> receivePayload(@RequestBody WebhookPojo payload) {
        pubSubTemplate.publish("projects/cloud-build-pipeline-396819/topics/ci-cd", gson.toJson(payload));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

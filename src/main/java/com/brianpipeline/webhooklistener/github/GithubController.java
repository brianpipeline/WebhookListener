package com.brianpipeline.webhooklistener.github;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/api")
public class GithubController {
    @PostMapping("/github-webhook")
    ResponseEntity<Void> receivePayload(@RequestBody WebhookPojo payload) {
        Gson gson = new Gson();
        String json = gson.toJson(payload);
        System.out.println(json);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

package com.brianpipeline.webhooklistener.github;

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

    public GithubController() {
    }

    @PostMapping("/github-webhook")
    ResponseEntity<Void> receivePayload(@RequestBody Map<String, Object> payload) {
        System.out.println(payload);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

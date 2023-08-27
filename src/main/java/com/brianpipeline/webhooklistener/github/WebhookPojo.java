package com.brianpipeline.webhooklistener.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
public class WebhookPojo {
    private final String ref;

    private final Repository repository;

    @JsonProperty("head_commit")
    private final HeadCommit headCommit;


    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor(force = true)
    public static final class Repository {
        @JsonProperty("clone_url")
        private final String cloneUrl;
    }


    public record HeadCommit(String id) {
    }
}

package com.brianpipeline.webhooklistener.github;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WebhookPojo {
    private final String ref;
    private final Repository repository;
    private final HeadCommit head_commit;


    @Builder
    @Data
    private static final class Repository {
        private final String clone_url;
    }

    @Builder
    @Data
    private static final class HeadCommit {
        private final String id;
    }
}

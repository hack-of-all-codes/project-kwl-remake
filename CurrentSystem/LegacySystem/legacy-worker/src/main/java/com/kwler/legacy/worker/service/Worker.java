package com.kwler.legacy.worker.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import lombok.extern.java.Log;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
@Log
public class Worker {

    @Value
    public static class Work {
        String id;
        String name;
        Long dataAcquired;

        @JsonCreator
        public Work(
                @JsonProperty("id") String id,
                @JsonProperty("name") String name,
                @JsonProperty("dataAcquired") Long dataAcquired
        ) {
           this.id = id;
           this.name = name;
           this.dataAcquired = dataAcquired;
        }
    }

    @SqsListener("${app.aws.queue.facebook}")
    public void work(Work work) {
        log.info("Got Work: " + work);
    }
}

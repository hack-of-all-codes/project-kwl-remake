package com.kwler.legacy.scheduler.service.tasks;

import com.kwler.legacy.scheduler.model.TaskContext;
import com.kwler.legacy.scheduler.model.TaskResult;
import com.kwler.legacy.scheduler.service.Task;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log
//@AllArgsConstructor
//@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FacebookTask implements Task {

    @lombok.Value
    class FBMessage {
        String id;
        String name;
        Long dataAcquired;
    }

    @Autowired
    QueueMessagingTemplate queue;

    @Value("${app.aws.queue.facebook}")
    String facebookQueueName;

    @Override
    public TaskResult run(TaskContext context) {
        long start = System.currentTimeMillis();

        FBMessage message = new FBMessage("1", "Test_"+start, start);
        log.info("Sending Message to Queue: " + facebookQueueName + " => " + message);
        queue.convertAndSend(facebookQueueName, message);

        long end = System.currentTimeMillis();

        TaskResult result = TaskResult.builder()
                .context(context)
                .success(true)
                .runStart(start)
                .runFinish(end)
                .runSchedule(context.getStart())
                .errorMessage(Optional.empty())
                .build();

        return result;
    }
}

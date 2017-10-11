package com.kwler.legacy.scheduler.service.tasks;

import com.kwler.legacy.scheduler.model.TaskContext;
import com.kwler.legacy.scheduler.model.TaskResult;
import com.kwler.legacy.scheduler.service.Task;
import org.springframework.stereotype.Service;

@Service
public class FacebookTask implements Task {

    @Override
    public TaskResult run(TaskContext context) {
        return null;
    }
}

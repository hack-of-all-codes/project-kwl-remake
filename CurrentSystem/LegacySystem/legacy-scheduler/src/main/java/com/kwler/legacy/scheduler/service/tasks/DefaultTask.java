package com.kwler.legacy.scheduler.service.tasks;

import com.kwler.legacy.scheduler.model.TaskContext;
import com.kwler.legacy.scheduler.model.TaskResult;
import com.kwler.legacy.scheduler.service.Task;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class DefaultTask implements Task {

    @Override
    public TaskResult run(TaskContext context) {
        return new TaskResult(context, true, Optional.empty(), context.getStart(), Collections.emptyMap());
    }
}

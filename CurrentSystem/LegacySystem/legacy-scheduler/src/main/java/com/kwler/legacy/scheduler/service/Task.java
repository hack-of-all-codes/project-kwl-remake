package com.kwler.legacy.scheduler.service;

import com.kwler.legacy.scheduler.model.TaskContext;
import com.kwler.legacy.scheduler.model.TaskResult;

public interface Task {
    TaskResult run(TaskContext context);
}

package com.kwler.legacy.scheduler.service;

import com.kwler.legacy.scheduler.model.TaskContext;
import com.kwler.legacy.scheduler.model.TaskResult;

public interface Task {

    /**
     * runs a task, ideally something small and quick
     * like pushing some command into a queue
     *
     * @param context
     * @return
     */
    TaskResult run(TaskContext context);
}

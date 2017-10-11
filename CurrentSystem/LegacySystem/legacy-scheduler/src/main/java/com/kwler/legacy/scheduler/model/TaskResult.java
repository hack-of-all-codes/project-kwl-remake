package com.kwler.legacy.scheduler.model;

import lombok.Value;

import java.util.Map;
import java.util.Optional;

@Value
public class TaskResult {

    TaskContext context;
    Boolean success;
    Optional<String> errorMessage;
    Long runSchedule;
    Long runStart;
    Long runFinish;

    /**
     * extra information about the run
     */
    Map<String, String> info;
}

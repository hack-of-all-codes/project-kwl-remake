package com.kwler.legacy.scheduler.model;

import lombok.Value;

import java.util.Map;
import java.util.Optional;

@Value
public class TaskResult {

    TaskContext context;
    Boolean success;
    Optional<String> errorMessage;
    Long runTime;
    Map<String, String> info;
}

package com.kwler.legacy.scheduler.model;

import lombok.Value;

@Value
public class TaskContext {

    JobSchedule jobSchedule;
    Long start;
}

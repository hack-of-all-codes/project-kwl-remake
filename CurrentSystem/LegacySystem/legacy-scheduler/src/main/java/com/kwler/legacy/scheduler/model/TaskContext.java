package com.kwler.legacy.scheduler.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TaskContext {

    JobSchedule jobSchedule;
    Long start;
}

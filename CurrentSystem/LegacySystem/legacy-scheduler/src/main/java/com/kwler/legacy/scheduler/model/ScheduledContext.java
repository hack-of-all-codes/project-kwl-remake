package com.kwler.legacy.scheduler.model;

import lombok.Value;

@Value
public class ScheduledContext {

    JobSchedule jobSchedule;
    Long start;
}

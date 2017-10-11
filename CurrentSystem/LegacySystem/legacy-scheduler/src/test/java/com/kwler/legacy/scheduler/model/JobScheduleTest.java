package com.kwler.legacy.scheduler.model;

import lombok.extern.java.Log;
import org.junit.Test;

import java.time.LocalDateTime;

import static com.kwler.legacy.scheduler.util.DateTimeUtil.toMs;
import static org.junit.Assert.assertTrue;

@Log
public class JobScheduleTest {

    @Test
    public void shouldRunWhenScheduled() {
        Long march01 = toMs(LocalDateTime.parse("2007-03-01T00:00:00"));
        Long march02 = toMs(LocalDateTime.parse("2007-03-02T00:00:01"));

        String runDailyCronExpression = "0 0 0 * * *";

        JobSchedule schedule = new JobSchedule();
        schedule.setLastRun(march01);
        schedule.setCronExpression(runDailyCronExpression);

        assertTrue(schedule.shouldRun(march02));
    }

}

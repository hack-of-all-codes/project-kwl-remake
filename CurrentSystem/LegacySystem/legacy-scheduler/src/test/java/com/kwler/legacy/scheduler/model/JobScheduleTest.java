package com.kwler.legacy.scheduler.model;

import lombok.extern.java.Log;
import org.junit.Test;
import org.springframework.scheduling.support.CronSequenceGenerator;

import java.util.Date;

import static org.junit.Assert.assertTrue;

@Log
public class JobScheduleTest {

    @Test
    public void shouldRunWhenScheduled() {
        Long march01 = new Date(2017, 02, 01).getTime();
        Long march02 = new Date(2017, 02, 02, 0, 0, 1).getTime();
        String runDailyCronExpression = "0 0 0 * * *";

        JobSchedule schedule = new JobSchedule();
        schedule.setLastRun(march01);
        schedule.setCronExpression(runDailyCronExpression);

        assertTrue(schedule.shouldRun(march02));
    }

}

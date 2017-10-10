package com.kwler.legacy.scheduler.model;

import lombok.extern.java.Log;
import org.junit.Test;
import org.springframework.scheduling.support.CronSequenceGenerator;

import java.util.Date;

import static org.junit.Assert.assertTrue;

@Log
public class JobScheduleTest {

    @Test
    public void shouldRun() {
        JobSchedule schedule = new JobSchedule();
        schedule.setLastRunActual(1l);
        schedule.setCronExpression("0 0 12 1/1 * ? *");

        assertTrue(schedule.shouldRun(System.currentTimeMillis()));
    }

    @Test
    public void demoCron() {
        CronSequenceGenerator sequenceGenerator = new CronSequenceGenerator("10 0 4 1,7,15 * *");
        log.info(String.format("=== %s", sequenceGenerator.next(new Date(System.currentTimeMillis()))));
    }

}

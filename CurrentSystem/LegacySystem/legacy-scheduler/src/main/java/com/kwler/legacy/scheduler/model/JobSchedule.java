package com.kwler.legacy.scheduler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * For performing calculation
 * https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html
 */
@Document(collection = "JobSchedule")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSchedule {

    @Id
    String id;

    /**
     * see:
     * http://www.manpagez.com/man/5/crontab/
     */
    String cronExpression;

    JobType jobType;
    Map<String, String> config;

    /**
     * schedule for the previous run
     */
    Long lastRunSchedule;

    /**
     * actual timestamp for the previous run
     */
    Long lastRunActual;

    /**
     *
     */
    Long nextRunSchedule;

    public void setCronExpression(String cronExpression) {
        if (!StringUtils.isEmpty(cronExpression)) {

        }
    }

    public boolean shouldRun(long l) {
        return false;
    }
}

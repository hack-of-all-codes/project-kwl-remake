package com.kwler.legacy.scheduler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.util.StringUtils;

import java.util.Date;
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
     * http://www.cronmaker.com/
     *
     * The pattern is a list of six single space-separated fields: representing second, minute, hour, day, month, weekday.
     * Month and weekday names can be given as the first three letters of the English names.
     * "0 0 * * * *" = the top of every hour of every day.
     * "* /10 * * * * *" = every ten seconds. ignore space after the *, comments wont allow me shit
     * "0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.
     * "0 0 6,19 * * *" = 6:00 AM and 7:00 PM every day.
     * "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30, 10:00 and 10:30 every day.
     * "0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays
     * "0 0 0 25 12 ?" = every Christmas Day at midnight
     */
    String cronExpression;

    /**
     * to determine which task should handle the processing
     */
    JobType jobType;

    /**
     * extra configuration data that we can pass along the task
     */
    Map<String, String> config;

    /**
     * actual timestamp for the previous run
     */
    Long lastRun;

    /**
     * evaluate if this schedule should execute for this time
     *
     * @param time
     * @return
     */
    public boolean shouldRun(long time) {
        if (!CronSequenceGenerator.isValidExpression(getCronExpression())) return false;
        CronSequenceGenerator sequenceGenerator = new CronSequenceGenerator(getCronExpression());
        return sequenceGenerator.next(new Date(time)).getTime() > getLastRun();
    }
}

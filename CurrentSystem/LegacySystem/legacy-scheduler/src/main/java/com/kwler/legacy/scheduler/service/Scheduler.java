package com.kwler.legacy.scheduler.service;

import com.kwler.legacy.scheduler.model.JobSchedule;
import com.kwler.legacy.scheduler.model.ScheduledContext;
import com.kwler.legacy.scheduler.repository.JobHistoryRestRepository;
import com.kwler.legacy.scheduler.repository.JobScheduleRestRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
@FieldDefaults(makeFinal=true, level= AccessLevel.PRIVATE)
@AllArgsConstructor
public class Scheduler {

    JobScheduleRestRepository jobScheduleRestRepository;
    JobHistoryRestRepository jobHistoryRestRepository;

    @Scheduled(fixedDelay = 1000L*60)
    public void runJobs() {

        List<JobSchedule> allSchedules = jobScheduleRestRepository.findAll();

        allSchedules.forEach(s -> {
            ScheduledJobRunner runner = resolveRunner(s);
            runner.run(new ScheduledContext(s, 1000l));
        });
    }

    protected ScheduledJobRunner resolveRunner(JobSchedule schedule) {
        return new FacebookJobInvoker();
    }
}

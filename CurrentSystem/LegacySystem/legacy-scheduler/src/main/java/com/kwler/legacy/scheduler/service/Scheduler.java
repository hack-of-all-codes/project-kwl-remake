package com.kwler.legacy.scheduler.service;

import com.kwler.legacy.scheduler.model.JobHistory;
import com.kwler.legacy.scheduler.model.JobSchedule;
import com.kwler.legacy.scheduler.model.TaskContext;
import com.kwler.legacy.scheduler.model.TaskResult;
import com.kwler.legacy.scheduler.repository.JobHistoryRestRepository;
import com.kwler.legacy.scheduler.repository.JobScheduleRestRepository;
import com.kwler.legacy.scheduler.service.tasks.DefaultTask;
import com.kwler.legacy.scheduler.service.tasks.FacebookTask;
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

    JobScheduleRestRepository scheduleRepository;
    JobHistoryRestRepository historyRepository;

    DefaultTask defaultTask;
    FacebookTask facebookTask;

    @Scheduled(fixedDelay = 1000L*60)
    public void runJobs() {

        List<JobSchedule> schedules = scheduleRepository.findAll();
        Long currentTime = System.currentTimeMillis();

        schedules.stream().filter(schedule->schedule.shouldRun(currentTime)).forEach(schedule ->  {
            TaskResult result = resolveTask(schedule).run(new TaskContext(schedule, 1000l));
            createHistory(result);
        });
    }

    /**
     * TODO: implement
     * @param schedule
     * @return
     */
    protected Task resolveTask(JobSchedule schedule) {
        switch (schedule.getJobType()) {
            case HARVEST_FACEBOOK:
                return facebookTask;
            default:
                return defaultTask;
        }
    }

    protected JobHistory createHistory(TaskResult result) {
        JobHistory history = new JobHistory();

        historyRepository.save(history);
        return history;
    }
}

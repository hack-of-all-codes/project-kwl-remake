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
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Scheduler {

    JobScheduleRestRepository scheduleRepository;
    JobHistoryRestRepository historyRepository;

    DefaultTask defaultTask;
    FacebookTask facebookTask;

    @Scheduled(fixedDelay = 1000L * 60)
    public void runJobs() {
        log.info("Looking for scheduled jobs...");

        List<JobSchedule> schedules = scheduleRepository.findAll();
        Long currentTime = System.currentTimeMillis();

        schedules.stream().filter(schedule -> schedule.shouldRun(currentTime)).forEach(schedule -> {
            TaskResult result = resolveTask(schedule).run(new TaskContext(schedule, currentTime));
            createHistory(result);
        });
    }

    /**
     * TODO: implement
     *
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
        JobSchedule schedule = result.getContext().getJobSchedule();
        schedule.setLastRun(result.getRunFinish());

        JobHistory history = new JobHistory();
        history.setJobScheduleId(schedule.getId());
        history.setMessage(result.getErrorMessage().orElse("Successful Run"));
        history.setInfo(result.getInfo());
        history.setRunActual(result.getRunFinish());
        history.setRunSchedule(result.getRunSchedule());

        scheduleRepository.save(schedule);
        historyRepository.save(history);
        return history;
    }
}

package com.kwler.legacy.scheduler.service.tasks;

import com.kwler.legacy.scheduler.model.TaskContext;
import com.kwler.legacy.scheduler.model.TaskResult;
import com.kwler.legacy.scheduler.service.Task;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Log
@Service
public class DefaultTask implements Task {

    @Override
    public TaskResult run(TaskContext context) {
        log.warning("Unimplemented Task: " + context);
        Long start = System.currentTimeMillis();

        //do something that takes a long time???
        try {
            Thread.sleep(10l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Long end = System.currentTimeMillis();

        Map<String, String> testInfo = new HashMap<>();
        testInfo.put("test", "test");

        return TaskResult.builder()
                .context(context)
                .success(true)
                .errorMessage(Optional.empty())
                .runSchedule(context.getStart())
                .runStart(start)
                .runFinish(end)
                .info(testInfo)
                .build();
    }
}

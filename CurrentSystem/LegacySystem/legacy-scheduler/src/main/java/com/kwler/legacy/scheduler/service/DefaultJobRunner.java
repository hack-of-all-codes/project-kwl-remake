package com.kwler.legacy.scheduler.service;

import com.kwler.legacy.scheduler.model.ScheduledContext;
import org.springframework.stereotype.Service;

@Service
public class DefaultJobRunner implements ScheduledJobRunner {

    @Override
    public void run(ScheduledContext context) {

    }
}

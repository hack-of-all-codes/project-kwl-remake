package com.kwler.legacy.scheduler.service;

import com.kwler.legacy.scheduler.model.ScheduledContext;

interface ScheduledJobRunner {
    void run(ScheduledContext context);
}

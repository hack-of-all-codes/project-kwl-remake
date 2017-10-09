package com.kwler.legacy.scheduler;

import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Log
public class TimeCheckerTask {

    @Scheduled(fixedRate = 1000)
    public void checkCurrentTime() {
        log.info("Time Check: " + new Date());
    }

}


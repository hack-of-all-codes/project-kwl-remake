package com.kwler.legacy.worker.scraper.service;

import com.kwler.legacy.worker.scraper.model.ScraperRequest;
import com.kwler.legacy.worker.scraper.model.ScraperResponse;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import org.openqa.selenium.phantomjs.PhantomJSDriver;

@Service
@Log
public class ScraperWorker {

    @Autowired
    PhantomJSDriver webDriver;

    @SqsListener("${app.aws.queue.scraper.request}")
    @SendTo("${app.aws.queue.scraper.result}")
    public ScraperResponse scrape(ScraperRequest request) {

        try {
            webDriver.get(request.getUrl());
            Thread.sleep(1000);

            return ScraperResponse.builder()
                    .id(request.getId())
                    .body(webDriver.getPageSource())
                    .title(webDriver.getTitle())
                    .success(true)
                    .build();
        } catch (Exception e) {
            return ScraperResponse.builder()
                    .id(request.getId())
                    .errorMessage(e.getMessage())
                    .success(false)
                    .build();
        }
    }
}

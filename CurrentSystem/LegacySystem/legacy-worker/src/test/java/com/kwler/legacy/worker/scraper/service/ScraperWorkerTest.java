package com.kwler.legacy.worker.scraper.service;

import com.kwler.legacy.worker.scraper.model.ScraperRequest;
import com.kwler.legacy.worker.scraper.model.ScraperResponse;
import com.kwler.legacy.worker.workaround.PhantomJSFixedDriver;
import lombok.extern.java.Log;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.Assert.assertTrue;

@Log
public class ScraperWorkerTest {

    @Test
    public void scrapeShouldGetHtml() {

        String driverLocation = "/Users/spark/Dev/project-kwl2/CurrentSystem/LegacySystem/legacy-worker/phantomjs_macos";
        System.setProperty("phantomjs.binary.path", driverLocation);

        String website = "https://github.com/psi-coder";
        String expectedTitle = "Psi Coder";
        String expectedBody = "project-kwl2";

        PhantomJSDriver driver = new PhantomJSFixedDriver(new DesiredCapabilities("phantomjs", "10.3", Platform.MAC));
        driver.manage().window().setSize(new Dimension(1920, 1080));

        ScraperWorker worker = new ScraperWorker();
        worker.webDriver = driver;


        ScraperRequest request = ScraperRequest.builder()
                .id("1")
                .url(website)
                .build();


        ScraperResponse response = worker.scrape(request);

        log.info("Found:" + response);
        assertTrue(response.getTitle().contains(expectedTitle));
        assertTrue(response.getBody().contains(expectedBody));
    }
}

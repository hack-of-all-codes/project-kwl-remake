package com.kwler.legacy.worker;

import lombok.extern.java.Log;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;

@Log
@SpringBootApplication
public class LegacyWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LegacyWorkerApplication.class, args);
	}

    /**
     * Didn't use spring social since i only need the graph api for the server side
     *
     * @param appId
     * @param appSecret
     * @return
     */
	@Bean
    Facebook facebook(@Value("${spring.social.facebook.app-id}") String appId, @Value("${spring.social.facebook.app-secret}") String appSecret) {
	    String appToken = String.format("%s|%s", appId, appSecret);
	    return new FacebookTemplate(appToken);
    }

    @Bean
	PhantomJSDriver phantomJSDriver(@Value("${phantomjs.binary.path}") String driverLocation) {
        System.setProperty("phantomjs.binary.path", driverLocation);
		PhantomJSDriver driver = new PhantomJSDriver(DesiredCapabilities.chrome());
		driver.manage().window().setSize(new Dimension(1920, 1080));
		return driver;
	}
}

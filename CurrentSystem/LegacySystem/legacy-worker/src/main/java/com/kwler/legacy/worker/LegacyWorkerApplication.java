package com.kwler.legacy.worker;

import lombok.extern.java.Log;
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
}

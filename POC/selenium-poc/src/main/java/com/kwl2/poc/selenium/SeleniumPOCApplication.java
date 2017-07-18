package com.kwl2.poc.selenium;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class SeleniumPOCApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(SeleniumPOCApplication.class, args);
	}
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		SpotifyHarvester harvester = new SpotifyHarvester();
		harvester.run();
	}
}

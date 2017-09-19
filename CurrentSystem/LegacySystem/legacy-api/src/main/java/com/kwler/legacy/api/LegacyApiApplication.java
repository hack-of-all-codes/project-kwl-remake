package com.kwler.legacy.api;

import com.kwler.legacy.api.metrics.mapper.FactFansMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LegacyApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LegacyApiApplication.class, args);
	}

	@Autowired
	FactFansMapper factFansMapper;

	@Override
	public void run(String... strings) throws Exception {
		System.out.println(factFansMapper.findArtists(3));
	}
}

package com.kwler.legacy.api;

import com.kwler.legacy.api.metrics.mapper.FactFansMapper;
import com.kwler.legacy.api.metrics.model.FactFans;
import com.kwler.legacy.api.metrics.model.PartialResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class LegacyApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LegacyApiApplication.class, args);
	}

	@Autowired
	FactFansMapper factFansMapper;

	@Override
	public void run(String... strings) throws Exception {
		PageRequest page = new PageRequest(0, 2);
		PartialResult<FactFans> result = factFansMapper.findFansByDateAndArtistId(20170807, "577a3d1c1669bd37321b2c29", page);
		System.out.println(result);
	}
}

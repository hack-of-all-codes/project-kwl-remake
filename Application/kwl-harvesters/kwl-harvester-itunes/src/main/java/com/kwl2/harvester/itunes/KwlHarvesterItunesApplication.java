package com.kwl2.harvester.itunes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.hadoop.fs.FsShell;

@SpringBootApplication
public class KwlHarvesterItunesApplication implements CommandLineRunner {
	
	@Autowired FsShell fsShell;

	public static void main(String[] args) {
		SpringApplication.run(KwlHarvesterItunesApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		fsShell.mkdir("/user/booty");
	}
}

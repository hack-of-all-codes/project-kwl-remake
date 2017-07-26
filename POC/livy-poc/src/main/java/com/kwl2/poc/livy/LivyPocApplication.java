package com.kwl2.poc.livy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//livy docs: https://github.com/apache/incubator-livy#rest-api
@SpringBootApplication
public class LivyPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivyPocApplication.class, args);
	}
}

package com.kwler.legacy.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;

@SpringBootApplication(exclude = {
        ElasticsearchAutoConfiguration.class,
        ElasticsearchDataAutoConfiguration.class
})
public class LegacyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LegacyApiApplication.class, args);
	}
}

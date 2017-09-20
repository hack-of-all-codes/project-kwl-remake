package com.kwler.legacy.api;

import com.kwler.legacy.api.metrics.dao.FactFanDAO;
import com.kwler.legacy.api.metrics.mapper.FactFanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication(exclude = {
        ElasticsearchAutoConfiguration.class,
        ElasticsearchDataAutoConfiguration.class
})
public class LegacyApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LegacyApiApplication.class, args);
	}

	@Autowired
    FactFanMapper factFanMapper;

	@Autowired
    FactFanDAO factFanDAO;

	@Override
	public void run(String... strings) throws Exception {
		PageRequest page = new PageRequest(1, 3);
		System.out.println(factFanDAO.findByArtistAndDate("577a3d1c1669bd37321b2c29", 20170807, page));
	}
}

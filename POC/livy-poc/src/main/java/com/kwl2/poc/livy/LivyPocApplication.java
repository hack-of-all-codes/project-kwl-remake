package com.kwl2.poc.livy;

import com.cloudera.livy.LivyClient;
import com.cloudera.livy.LivyClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

//livy docs: https://github.com/apache/incubator-livy#rest-api
@SpringBootApplication
public class LivyPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivyPocApplication.class, args);
	}

	@Bean
	LivyClient livyClient(@Value("${livy.host}") String livyHost) throws IOException, URISyntaxException {
		return new LivyClientBuilder().setURI(new URI(livyHost)).build();
	}

	@Bean
	CommandLineRunner runner(@Autowired LivyClient livyClient) {
	    return (args) -> {

            System.out.println("Uploading...");
	        livyClient.addJar(new URI("hdfs:///user/admin/spark-scala-poc-assembly-1.0.jar"));

	        double pi = livyClient.submit(new PiJob(10)).get();
	        System.out.println("Pi is:" + pi);
        };
    }
}

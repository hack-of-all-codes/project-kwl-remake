package com.kwl2.masterdata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class KwlMasterDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(KwlMasterDataApplication.class, args);
	}

	@Component
	class StartupRunner implements CommandLineRunner {

		@Autowired ArtistRepository artistRepository;

		@Override
		public void run(String... strings) throws Exception {
			artistRepository.findAll(PageRequest.of(1, 10)).forEach(System.out::println);
		}
	}
}

@RepositoryRestResource(collectionResourceRel = "artist")
interface ArtistRepository extends MongoRepository<Artist, String> {

}

@Data @NoArgsConstructor @AllArgsConstructor
class Artist {
	String name;
}
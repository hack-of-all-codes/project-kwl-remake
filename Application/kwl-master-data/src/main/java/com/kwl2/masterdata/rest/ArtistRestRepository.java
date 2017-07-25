package com.kwl2.masterdata.rest;

import com.kwl2.masterdata.model.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "artist")
public interface ArtistRestRepository extends MongoRepository<Artist, String> {
}

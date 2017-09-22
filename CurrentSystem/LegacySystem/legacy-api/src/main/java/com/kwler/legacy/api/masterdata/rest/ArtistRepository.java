package com.kwler.legacy.api.masterdata.rest;

import com.kwler.legacy.api.masterdata.model.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArtistRepository  extends MongoRepository<Artist, String> {
}

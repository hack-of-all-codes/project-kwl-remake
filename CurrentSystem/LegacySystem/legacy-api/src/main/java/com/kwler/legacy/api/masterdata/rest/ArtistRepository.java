package com.kwler.legacy.api.masterdata.rest;

import com.kwler.legacy.api.masterdata.model.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtistRepository  extends MongoRepository<Artist, String> {
}

package com.kwl2.masterdata.rest.itunes;

import com.kwl2.masterdata.model.itunes.ITunesArtist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "iTunesArtist")
public interface ITunesArtistRestRepository extends MongoRepository<ITunesArtist, String> {
}

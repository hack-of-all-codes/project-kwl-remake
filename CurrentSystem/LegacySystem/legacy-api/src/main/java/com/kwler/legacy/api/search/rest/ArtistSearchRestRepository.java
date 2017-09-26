package com.kwler.legacy.api.search.rest;

import com.kwler.legacy.api.search.model.ArtistSearch;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface ArtistSearchRestRepository extends PagingAndSortingRepository<ArtistSearch, String> {
}

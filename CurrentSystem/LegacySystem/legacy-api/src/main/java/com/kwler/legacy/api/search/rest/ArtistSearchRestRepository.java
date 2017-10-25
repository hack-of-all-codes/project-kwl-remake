package com.kwler.legacy.api.search.rest;

import com.kwler.legacy.api.search.model.ArtistSearch;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArtistSearchRestRepository extends PagingAndSortingRepository<ArtistSearch, String> {
}

package com.kwler.legacy.api.search.rest;

import com.kwler.legacy.api.search.model.DemoSearch;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DemoSearchRestRepository extends PagingAndSortingRepository<DemoSearch, String> {
}

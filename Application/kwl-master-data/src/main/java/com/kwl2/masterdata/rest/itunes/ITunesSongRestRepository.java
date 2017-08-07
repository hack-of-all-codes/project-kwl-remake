package com.kwl2.masterdata.rest.itunes;

import com.kwl2.masterdata.model.itunes.ITunesSong;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "iTunesSong")
public interface ITunesSongRestRepository extends PagingAndSortingRepository<ITunesSong, Long> {
}

package com.kwl2.masterdata.rest.itunes;

import com.kwl2.masterdata.model.itunes.ITunesArtistSong;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "iTunesArtistSong")
public interface ITunesArtistSongRestRepository extends PagingAndSortingRepository<ITunesArtistSong, Long> {
}

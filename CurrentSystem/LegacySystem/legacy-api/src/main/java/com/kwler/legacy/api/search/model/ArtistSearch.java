package com.kwler.legacy.api.search.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Data
@Document(indexName = "artist-search", type = "content")
public class ArtistSearch {

    @Id
    String id;
    String name;
    String nameFront;
    Boolean tracked;
    Integer newRelease;
    String country;
    String itunesArtistId;
    List<String> namePartial;
    List<String> genres;
    List<String> aliasFront;
    List<String> aliasPartial;
    String photoUrl;
}

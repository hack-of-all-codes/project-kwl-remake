package com.kwler.legacy.api.metrics.model;

import lombok.Data;

import java.util.List;

@Data
public class ArtistResults {

    Long totalCount;
    List<DimArtists> artists;

}

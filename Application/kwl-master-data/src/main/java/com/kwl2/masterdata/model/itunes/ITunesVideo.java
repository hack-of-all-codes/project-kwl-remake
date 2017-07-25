package com.kwl2.masterdata.model.itunes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Video metadata. In most cases, one video is contained only in one collection.
 * But in some cases, one video is shared by multiple collections.
 * (Music videos, movies, short films, and TV episodes.)
 */
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ITunesVideo extends ITunesBase {

    Long videoId;
    Long parentalAdvisoryId;
    Long mediaTypeId;

    String name;
    String titleVersion;
    String searchTerms;
    String artistDisplayName;
    String collectionDisplayName;
    String viewUrl;
    String artworkUrl;
    String originalReleaseDate;
    String itunesReleaseDate;
    String studioName;
    String networkName;
    String contentProvider;
    Long trackLength;
    String copyright;
    String pLine;
    String shortDescription;
    String longDescription;
    Integer episodeProductionNumber;

}

package com.kwl2.masterdata.model.itunes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * A collection can contain multiple songs and videos, and can represent a music album, audiobook, or TV season.
 */
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ITunesCollection extends ITunesBase {

    Long collectionId;
    Long collectionTypeId;
    Long parentalAdvisoryId;
    Long mediaTypeId;

    String name;
    String titleVersion;
    String searchTerms;
    String artistDisplayName;
    String viewUrl;
    String artworkUrl;
    String originalReleaseDate; //yyyy mm dd
    String itunesReleaseDate;
    String labelStudio;
    String contentProvider;
    String copyright;
    String pLine;
    Boolean isCompilation;

}

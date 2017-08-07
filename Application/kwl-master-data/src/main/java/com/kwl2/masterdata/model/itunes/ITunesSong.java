package com.kwl2.masterdata.model.itunes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * Song metadata. In most cases, one song is only contained in one collection.
 * But in some cases, one song is shared by multiple collections.
 */
@Data
@Entity
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ITunesSong extends ITunesBase {

    Long songId;
    Long parentalAdvisoryId;

    String name;
    String titleVersion;
    String searchTerms;
    String artistDisplayName;
    String collectionDisplayName;
    String viewUrl;
    String originalReleaseDate;
    String itunesReleaseDate;
    Long trackLength;
    String copyright;
    String pLine;
    String previewUrl;
    Long previewLength;

}

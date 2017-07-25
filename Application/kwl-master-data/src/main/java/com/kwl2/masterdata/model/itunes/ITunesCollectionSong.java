package com.kwl2.masterdata.model.itunes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Many-to-many relationship between collections and songs.
 * Most of the songs are included only in one collection.
 *
 * Every collection has at least one song or video.
 * There is no empty collection.
 * Every song belongs to at least one collection.
 * There is no standalone song without its collection.
 */
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ITunesCollectionSong extends ITunesBase {

    Long collectionId;
    Long songId;
    Boolean isPrimaryCollection;
    Integer trackNumber;
    Integer volumeNumber;
    Boolean preorderOnly;

}

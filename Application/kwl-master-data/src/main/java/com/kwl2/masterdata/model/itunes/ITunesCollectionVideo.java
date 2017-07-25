package com.kwl2.masterdata.model.itunes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Many-to-many relationship between collections and videos.
 * Every collection has at least one song or video.
 * There are no empty collections.
 *
 * A video can be standalone with no parent collection.
 * Single music video has no parent.
 * But video can also be included in collections.
 * For example, video album is a collection with multiple videos in it.
 * And bonus video is typically a video contained in a music album (for free).
 */
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ITunesCollectionVideo extends ITunesBase {

    Long collectionId;
    Long videoId;

    Integer trackNumber;
    Integer volumeNumber;
    Boolean preorderOnly;
}

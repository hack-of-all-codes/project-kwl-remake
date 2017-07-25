package com.kwl2.masterdata.model.itunes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Many-to-many relationship between artists and videos.
 * Only primary artists are included.
 *
 * Every video has at least one artist and can have multiple artists.
 * One artist can participate in multiple collections.
 */
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ITunesArtistVideo extends ITunesBase {

    Long artistId;
    Long videoId;
    Long roleId;

    Boolean isPrimaryArtist;
}

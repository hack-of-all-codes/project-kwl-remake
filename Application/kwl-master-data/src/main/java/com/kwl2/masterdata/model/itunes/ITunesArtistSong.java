package com.kwl2.masterdata.model.itunes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Many-to-many relationship between artists and songs.
 * Only primary artists are included.
 *
 * Every song has at least one artist and can have multiple artists.
 * One artist can participate in multiple songs.
 */
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ITunesArtistSong extends ITunesBase {

    Long artistId;
    Long songId;
    Long roleId;

}

package com.kwl2.masterdata.model.itunes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * Artist metadata.
 * Unlike other Content and Join tables,
 * this artist table contains all the artists,
 * regardless of availability of the artist’s contents in any given country of interest.
 */
@Entity
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ITunesArtist extends ITunesBase {

    Long artistId;
    String name;
    String searchTerms;
    Boolean isActualArtist;
    String viewUrl;
    Long artistTypeId;

}

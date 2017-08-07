package com.kwl2.masterdata.model.itunes;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Common fields for all iTunes data export
 */
@Data
@MappedSuperclass
public abstract class ITunesBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String exportDate;
    ExportMode exportMode;

}

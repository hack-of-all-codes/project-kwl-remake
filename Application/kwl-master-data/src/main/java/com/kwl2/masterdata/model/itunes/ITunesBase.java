package com.kwl2.masterdata.model.itunes;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Common fields for all iTunes data export
 */
@Data
public abstract class ITunesBase {

    @Id
    String id;

    String exportDate;
    ExportMode exportMode;

}

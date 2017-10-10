package com.kwler.legacy.scheduler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

/**
 * for storing run histories
 */
@Document(collection = "JobHistory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobHistory {

    @Id
    String id;

    /**
     * reference to the mongo id of the job schedule
     */
    String jobScheduleId;

    Long runSchedule;
    Long runActual;

    String message;

    Map<String, String> info;
}

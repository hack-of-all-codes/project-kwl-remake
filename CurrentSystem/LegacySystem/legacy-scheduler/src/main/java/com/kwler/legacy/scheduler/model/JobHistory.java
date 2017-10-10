package com.kwler.legacy.scheduler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "JobHistory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobHistory {

    @Id
    String id;

    String jobScheduleId;

    Long runSchedule;
    Long runActual;

    String message;
}

package com.kwler.legacy.scheduler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "JobSchedule")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSchedule {

    @Id
    String id;

    String cronExpression;
    JobType jobType;
    Map<String, String> config;

    Long lastRunSchedule;
    Long lastRunActual;
    Long nextRunSchedule;
}

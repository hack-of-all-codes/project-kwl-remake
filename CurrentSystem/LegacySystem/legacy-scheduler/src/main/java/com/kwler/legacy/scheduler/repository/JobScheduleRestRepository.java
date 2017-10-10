package com.kwler.legacy.scheduler.repository;

import com.kwler.legacy.scheduler.model.JobSchedule;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobScheduleRestRepository extends MongoRepository<JobSchedule, String> {
}

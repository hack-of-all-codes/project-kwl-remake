package com.kwler.legacy.scheduler.repository;

import com.kwler.legacy.scheduler.model.JobHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobHistoryRestRepository extends MongoRepository<JobHistory, String> {
}

package com.kwler.legacy.api.dashboard.repository;

import com.kwler.legacy.api.dashboard.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRestRepository extends MongoRepository<Customer, String> {
}

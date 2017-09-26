package com.kwler.legacy.api.admin.repository;

import com.kwler.legacy.api.admin.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRestRepository extends MongoRepository<Customer, String> {
}

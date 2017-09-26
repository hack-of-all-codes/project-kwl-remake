package com.kwler.legacy.api.dashboard.repository;

import com.kwler.legacy.api.dashboard.model.UserRegistration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface UserRegistrationRestRepository extends MongoRepository<UserRegistration, String> {
}

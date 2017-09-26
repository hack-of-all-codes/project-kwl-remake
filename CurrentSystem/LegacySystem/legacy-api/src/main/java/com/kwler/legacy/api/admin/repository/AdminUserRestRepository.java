package com.kwler.legacy.api.admin.repository;

import com.kwler.legacy.api.admin.model.AdminUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AdminUserRestRepository extends MongoRepository<AdminUser, String> {
}

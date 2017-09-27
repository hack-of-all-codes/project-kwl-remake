package com.kwler.legacy.api.admin.repository;

import com.kwler.legacy.api.admin.model.AdminUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        path = "customers",
        itemResourceRel = "customer",
        collectionResourceRel = "customers"
)
public interface AdminUserRestRepository extends MongoRepository<AdminUser, String> {

    AdminUser findFirstByUserProfileEmail(@Param("email") String email);
}

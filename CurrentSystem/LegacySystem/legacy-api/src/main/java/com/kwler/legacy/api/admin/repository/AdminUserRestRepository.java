package com.kwler.legacy.api.admin.repository;

import com.kwler.legacy.api.admin.model.AdminUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface AdminUserRestRepository extends MongoRepository<AdminUser, String> {

    AdminUser findFirstByUserProfileEmail(@Param("email") String email);
}

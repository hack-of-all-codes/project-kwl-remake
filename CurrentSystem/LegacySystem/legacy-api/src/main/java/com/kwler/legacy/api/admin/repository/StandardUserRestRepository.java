package com.kwler.legacy.api.admin.repository;

import com.kwler.legacy.api.admin.model.StandardUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StandardUserRestRepository extends MongoRepository<StandardUser, String> {

    Page<StandardUser> findByUserProfileEmail(@Param("email") String email, Pageable var1);
    StandardUser findFirstByUserProfileEmail(@Param("email") String email);
}

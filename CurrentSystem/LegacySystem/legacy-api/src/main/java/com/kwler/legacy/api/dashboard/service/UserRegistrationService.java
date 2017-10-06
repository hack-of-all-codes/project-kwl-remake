package com.kwler.legacy.api.dashboard.service;

import com.kwler.legacy.api.admin.model.StandardUser;
import com.kwler.legacy.api.dashboard.model.Registration;
import org.springframework.security.access.prepost.PreAuthorize;

public interface UserRegistrationService {

    @PreAuthorize("hasRole('ADMIN')")
    StandardUser register(Registration registration);
}

package com.kwler.legacy.api.dashboard.rest;

import com.kwler.legacy.api.dashboard.model.Registration;
import com.kwler.legacy.api.admin.model.StandardUser;
import com.kwler.legacy.api.dashboard.service.UserRegistrationService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/registration")
@FieldDefaults(makeFinal=true, level= AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserRegistrationRest {

    UserRegistrationService service;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    public StandardUser register(@RequestBody Registration registration) {
        return service.register(registration);
    }
}

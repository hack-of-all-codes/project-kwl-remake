package com.kwler.legacy.api.dashboard.rest;

import com.kwler.legacy.api.admin.model.StandardUser;
import com.kwler.legacy.api.dashboard.model.Registration;
import com.kwler.legacy.api.dashboard.service.UserRegistrationService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/test-security")
@FieldDefaults(makeFinal=true, level= AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserRegistrationRest {

    UserRegistrationService service;

    @RequestMapping(method = RequestMethod.POST)
    public StandardUser register(@RequestBody Registration registration) {
        return service.register(registration);
    }
}

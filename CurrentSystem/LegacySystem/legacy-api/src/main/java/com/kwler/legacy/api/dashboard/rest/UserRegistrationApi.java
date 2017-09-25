package com.kwler.legacy.api.dashboard.rest;

import com.kwler.legacy.api.dashboard.model.Registration;
import com.kwler.legacy.api.dashboard.model.StandardUser;
import com.kwler.legacy.api.dashboard.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "user/registration")
public class UserRegistrationApi {

    @Autowired
    UserRegistrationService service;

    @RequestMapping(method = RequestMethod.POST)
    public StandardUser register(Registration registration) {
        return service.register(registration);
    }
}

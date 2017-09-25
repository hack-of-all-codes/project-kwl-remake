package com.kwler.legacy.api.dashboard.rest;

import com.kwler.legacy.api.dashboard.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "user/registration")
public class UserRegistrationApi {

    @Autowired
    UserRegistrationService service;
}

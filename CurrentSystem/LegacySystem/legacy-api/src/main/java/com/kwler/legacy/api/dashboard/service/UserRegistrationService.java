package com.kwler.legacy.api.dashboard.service;

import com.kwler.legacy.api.dashboard.repository.StandardUserRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    @Autowired
    StandardUserRestRepository standardUserRestRepository;
}

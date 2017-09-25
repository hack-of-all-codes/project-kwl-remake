package com.kwler.legacy.api.security;

import com.kwler.legacy.api.dashboard.repository.StandardUserRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StandardUserDetailsService implements UserDetailsService {

    @Autowired
    StandardUserRestRepository standardUserRestRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new KWLStandardUserDetails(standardUserRestRepository.findFirstByUserProfileEmail(username));
    }
}

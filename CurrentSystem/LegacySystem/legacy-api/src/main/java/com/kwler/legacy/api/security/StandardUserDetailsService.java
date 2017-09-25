package com.kwler.legacy.api.security;

import com.kwler.legacy.api.dashboard.model.StandardUser;
import com.kwler.legacy.api.dashboard.repository.StandardUserRestRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(makeFinal=true, level= AccessLevel.PRIVATE)
@AllArgsConstructor
public class StandardUserDetailsService implements UserDetailsService {

    StandardUserRestRepository standardUserRestRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        StandardUser user = standardUserRestRepository.findFirstByUserProfileEmail(username);
        if (user == null) throw new UsernameNotFoundException("user does not exist: " + username);
        return new KWLStandardUserDetails(user);
    }
}

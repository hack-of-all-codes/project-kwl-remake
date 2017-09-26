package com.kwler.legacy.api.security;

import com.kwler.legacy.api.admin.model.AdminUser;
import com.kwler.legacy.api.admin.model.StandardUser;
import com.kwler.legacy.api.admin.repository.AdminUserRestRepository;
import com.kwler.legacy.api.admin.repository.StandardUserRestRepository;
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
    AdminUserRestRepository adminUserRestRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUser adminUser = adminUserRestRepository.findFirstByUserProfileEmail(username);
        if (adminUser != null) return new KWLAdminUserDetails(adminUser);

        StandardUser user = standardUserRestRepository.findFirstByUserProfileEmail(username);
        if (user == null) throw new UsernameNotFoundException("user does not exist: " + username);
        return new KWLStandardUserDetails(user);
    }
}

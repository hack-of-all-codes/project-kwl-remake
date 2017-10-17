package com.kwler.legacy.api.security;

import com.kwler.legacy.api.admin.model.AdminUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

@AllArgsConstructor
public class KWLAdminUserDetails implements UserDetails {

    private final AdminUser adminUser;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(
                new SimpleGrantedAuthority("ROLE_USER"),
                new SimpleGrantedAuthority("ROLE_ADMIN")
        );
    }

    public AdminUser getAdminUser() {
        return adminUser;
    }

    @Override
    public String getPassword() {
        return adminUser.getUserAccount().getHashedPassword();
    }

    @Override
    public String getUsername() {
        return adminUser.getUserProfile().getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

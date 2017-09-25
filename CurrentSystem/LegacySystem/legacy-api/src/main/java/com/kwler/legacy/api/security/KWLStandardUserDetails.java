package com.kwler.legacy.api.security;

import com.kwler.legacy.api.dashboard.model.StandardUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@AllArgsConstructor
public class KWLStandardUserDetails implements UserDetails {

    private final StandardUser standardUser;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        if (hasUser()) return standardUser.getUserAccount().getHashedPassword();
        return null;
    }

    @Override
    public String getUsername() {
        if (hasUser()) return standardUser.getUserProfile().getEmail();
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return hasUser();
    }

    @Override
    public boolean isAccountNonLocked() {
        return hasUser();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return hasUser();
    }

    @Override
    public boolean isEnabled() {
        return hasUser();
    }

    private boolean hasUser() {
        return standardUser != null;
    }
}

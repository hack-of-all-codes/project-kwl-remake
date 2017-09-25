package com.kwler.legacy.api.dashboard.model;

import com.kwler.legacy.api.masterdata.model.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Data
@Document(collection = "user")
@NoArgsConstructor @AllArgsConstructor
public class StandardUser implements UserDetails {

    @Id
    String id;

    UserAccount userAccount;
    UserProfile userProfile;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return userAccount.getHashedPassword();
    }

    @Override
    public String getUsername() {
        return userProfile.getEmail();
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

    @Data @NoArgsConstructor
    public static class UserAccount {

        String hashedPassword;
        List<PersistentToken> persistentTokens;
        List<Role> roles;
        String passwordResetCode;
        Long passwordResetCodeExpiry;
        Type type;

        @Data @NoArgsConstructor
        public class Role {
            RoleName roleName;
        }

        @Data @NoArgsConstructor
        public class PersistentToken {
            String id;
            Long expiry;
        }

        enum Type {
            STANDARD, INTERNAL
        }

        enum RoleName {
            ADMIN, SELF, DEFAULT, SERVER
        }
    }

    @Data @NoArgsConstructor
    public static class UserProfile {
        String fullName;
        String email;
        String name;
        Gender gender;
        Country country;
        List<String> recentlyViewedArtists;
        String facebookId;
        String linkedInId;
        String customerId;
        List<String> viewedReleaseUpdate = new ArrayList<>();
        Boolean enabled;
        Boolean onBoarded = false;
        Boolean needsVerification;
        String verificationCode;
        Long verificationCodeExpiry;
        String industryRole;

        enum Gender {
            M, F
        }
    }
}

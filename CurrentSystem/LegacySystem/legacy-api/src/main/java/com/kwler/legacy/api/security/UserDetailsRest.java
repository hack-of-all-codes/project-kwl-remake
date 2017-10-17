package com.kwler.legacy.api.security;

import com.kwler.legacy.api.admin.model.AdminUser;
import com.kwler.legacy.api.admin.model.StandardUser;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth/user")
@FieldDefaults(makeFinal=true, level= AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserDetailsRest {

    @Value
    @Builder
    public static class User {
        String userId;
        String email;
        String fullName;
    }

    @RequestMapping(method = RequestMethod.GET)
    public User currentUser(@AuthenticationPrincipal UserDetails user) {
        if (user instanceof KWLAdminUserDetails) {
            AdminUser a = ((KWLAdminUserDetails) user).getAdminUser();

            return User.builder()
                    .email(a.getUserProfile().getEmail())
                    .fullName(a.getUserProfile().getFullName())
                    .userId(a.getId())
                    .build();
        } else if (user instanceof KWLStandardUserDetails) {
            StandardUser s = ((KWLStandardUserDetails) user).getStandardUser();

            return User.builder()
                    .email(s.getUserProfile().getEmail())
                    .fullName(s.getUserProfile().getFullName())
                    .userId(s.getId())
                    .build();
        }
        return null;
    }
}

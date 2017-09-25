package com.kwler.legacy.api.dashboard.model;

import com.kwler.legacy.api.masterdata.model.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class StandardUser {

    @Id
    String id;

    UserAccount userAccount;
    UserProfile userProfile;

    @Data
    @NoArgsConstructor
    public static class UserAccount {

        String hashedPassword;
        List<PersistentToken> persistentTokens;
        List<Role> roles;
        String passwordResetCode;
        Long passwordResetCodeExpiry;
        Type type;
        Date registerDate;

        @Data
        @NoArgsConstructor
        class Role {
            RoleName roleName;
        }

        @Data
        @NoArgsConstructor
        class PersistentToken {
            String id;
            Long expiry;
        }

        public enum Type {
            STANDARD, INTERNAL
        }

        public enum RoleName {
            ADMIN, SELF, DEFAULT, SERVER
        }
    }

    @Data
    @NoArgsConstructor
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

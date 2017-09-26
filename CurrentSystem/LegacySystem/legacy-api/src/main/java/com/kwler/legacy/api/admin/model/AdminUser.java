package com.kwler.legacy.api.admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "admin")
public class AdminUser {

    @Id
    String id;

    UserAccount userAccount;
    UserProfile userProfile;

    @Data
    @NoArgsConstructor
    static class UserAccount {

        String hashedPassword;
        List<UserAccount.PersistentToken> persistentTokens;
        List<UserAccount.Role> roles;
        String passwordResetCode;
        Long passwordResetCodeExpiry;
        UserAccount.Type type;
        Date registerDate;

        @Data
        @NoArgsConstructor
        class Role {
            UserAccount.RoleName roleName;
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
    static class UserProfile {
        String fullName;
        String email;
        String name;
        UserProfile.Gender gender;
        String facebookId;

        enum Gender {
            M, F
        }
    }

}

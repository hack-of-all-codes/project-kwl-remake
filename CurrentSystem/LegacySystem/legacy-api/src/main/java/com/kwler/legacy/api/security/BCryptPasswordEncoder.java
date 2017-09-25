package com.kwler.legacy.api.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword.toString(), BCrypt.gensalt());
    }

    @Override
    public boolean matches(CharSequence plainTextPassword, String encryptedPassword) {
        return BCrypt.checkpw(plainTextPassword.toString(), encryptedPassword);
    }
}

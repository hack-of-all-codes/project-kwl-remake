package com.kwler.legacy.api.security;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BCryptPasswordEncoderTest {

    @Test
    public void shouldMatchEncodedPassword() {
        String password = "password";
        String encrypted = "$2a$10$05AIH63wKzUhKpB8qi5fB.olScLRR346E/X2L8invLjvZgxnvMaaq";

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        assertTrue(encoder.matches(password, encrypted));
    }
}

package com.kwler.legacy.api.security;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BCryptPasswordEncoderTest {

    @Test
    public void shouldMatchEncodedPassword() {
        String password = "MYRWodjc3237";
        String encrypted = "$2a$10$zV9U.r64/QLlMmhuVOu0ZuQDOEdUHKcqe22VawbMLBLcofYXKSJ1e";

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        assertTrue(encoder.matches(password, encrypted));
    }
}

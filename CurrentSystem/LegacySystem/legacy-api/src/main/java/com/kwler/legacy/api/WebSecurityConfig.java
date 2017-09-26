package com.kwler.legacy.api;

import com.kwler.legacy.api.security.BCryptPasswordEncoder;
import com.kwler.legacy.api.security.StandardUserDetailsService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@FieldDefaults(makeFinal=true, level= AccessLevel.PRIVATE)
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    StandardUserDetailsService standardUserDetailsService;
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/registration", "/browser/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/adminUsers/**").hasRole("ADMIN")
                    .antMatchers("/standardUsers/**").hasAnyRole("ADMIN", "STANDARD")
                    .anyRequest().authenticated()

                .and().httpBasic()
                .and().csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(standardUserDetailsService)
                .passwordEncoder(passwordEncoder);
    }

}

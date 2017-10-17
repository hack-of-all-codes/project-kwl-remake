package com.kwler.legacy.api;

import com.kwler.legacy.api.security.BCryptPasswordEncoder;
import com.kwler.legacy.api.security.StandardUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, mode = AdviceMode.ASPECTJ)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    StandardUserDetailsService standardUserDetailsService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Value("${app.cors.allowed.origins}")
    String[] allowedOrigins;

    @Value("${app.cors.allowed.methods}")
    String[] allowedMethods;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/browser/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/adminUsers/**").hasRole("ADMIN")
                    .antMatchers("/standardUsers/**").hasAnyRole("ADMIN", "STANDARD")
                    .anyRequest().authenticated()

                .and().httpBasic()
                .and().cors()
                .and().csrf().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(standardUserDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(allowedOrigins));
        configuration.setAllowedMethods(Arrays.asList(allowedMethods));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}

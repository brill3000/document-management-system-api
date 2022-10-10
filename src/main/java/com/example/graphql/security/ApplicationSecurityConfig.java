package com.example.graphql.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApplicationSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login").permitAll()
                .antMatchers("/graphiql/**", "/vendor/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable();
        http.headers().frameOptions().sameOrigin();
        return http.build();
    }

}

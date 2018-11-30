package com.tecgurus.useraccounts.common.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(
                        "/api-user-accounts/users/register",
                        "/api-user-accounts/users/confirm"
                ).permitAll()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/api-user-accounts/**").authenticated();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS);
    }

}

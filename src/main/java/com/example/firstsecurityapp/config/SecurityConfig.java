package com.example.firstsecurityapp.config;

import com.example.firstsecurityapp.security.AuthProviderImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private AuthProviderImp authProvider;

    @Autowired
    public SecurityConfig(AuthProviderImp authProvider) {
        this.authProvider = authProvider;
    }

    //setting authentication
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider);
    }
}
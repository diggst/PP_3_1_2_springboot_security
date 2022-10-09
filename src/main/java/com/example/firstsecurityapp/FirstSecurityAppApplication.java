package com.example.firstsecurityapp;

import com.example.firstsecurityapp.model.User;
import com.example.firstsecurityapp.services.UserService;
import com.example.firstsecurityapp.services.UserServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class FirstSecurityAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstSecurityAppApplication.class, args);
    }
}
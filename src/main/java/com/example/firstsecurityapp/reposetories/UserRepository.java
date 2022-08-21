package com.example.firstsecurityapp.reposetories;

import com.example.firstsecurityapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional
    Optional<User> findByUsername(String username);

}
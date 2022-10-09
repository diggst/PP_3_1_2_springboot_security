package com.example.firstsecurityapp.services;

import com.example.firstsecurityapp.model.User;
import com.example.firstsecurityapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userDAO;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImp(UserRepository userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> index() {
        return userDAO.findAll();
    }

    @Override
    @Transactional
    public void saveUser(User newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userDAO.save(newUser);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void updateUser(User updUser) {
        userDAO.save(updUser);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(long id) {
        return userDAO.getReferenceById(id);
    }

    @Override
    @Transactional
    public Optional <User> findByUsername (String username) {
        return userDAO.findByUsername(username);
    }
}
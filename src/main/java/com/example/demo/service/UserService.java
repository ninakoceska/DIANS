package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {

    User findUser(String username,String pass);

    Optional<User> findAllById(Long id);

    User findAllByUsername(String username);

    User saveUser(String username,String pass,String email);

    User authenticate(String username,String pass);

    List<User> findAllUsers();
}

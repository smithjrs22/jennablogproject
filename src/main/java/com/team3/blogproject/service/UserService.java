package com.team3.blogproject.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.team3.blogproject.model.User;
import com.team3.blogproject.service.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);

//gets all users and creates a list of users
List<User> getAllUsers();

    User findByUserName(String name);
}
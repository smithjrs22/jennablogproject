package com.team3.blogproject.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.team3.blogproject.model.User;
import com.team3.blogproject.service.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);

    User findByUserName(String name);
}
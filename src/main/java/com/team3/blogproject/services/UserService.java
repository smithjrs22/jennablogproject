package com.team3.blogproject.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.team3.blogproject.models.User;
import com.team3.blogproject.services.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
}
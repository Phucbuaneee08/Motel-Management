package com.example.MotelManagement.service;

import com.example.MotelManagement.entities.User;
import com.example.MotelManagement.model.UserRegistrationDto;
import com.example.MotelManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {
    void save(UserRegistrationDto registrationDto);
}



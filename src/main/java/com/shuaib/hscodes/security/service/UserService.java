package com.shuaib.hscodes.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shuaib.hscodes.security.entity.User;
import com.shuaib.hscodes.security.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
}

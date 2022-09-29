package com.burakenesdemir.basebackend.service;

import com.burakenesdemir.basebackend.exception.UserNotFoundException;
import com.burakenesdemir.basebackend.model.mongo.User;
import com.burakenesdemir.basebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username).orElseThrow(
                () -> new UserNotFoundException("User not found by username: " + username));
    }

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }
}

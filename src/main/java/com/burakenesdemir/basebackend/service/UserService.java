package com.burakenesdemir.basebackend.service;

import com.burakenesdemir.basebackend.model.mongo.User;

public interface UserService {
    User getByUsername(String username);
}

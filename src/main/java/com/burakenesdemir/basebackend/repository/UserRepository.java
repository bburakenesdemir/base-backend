package com.burakenesdemir.basebackend.repository;

import com.burakenesdemir.basebackend.model.mongo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> getByUsername(String username);
}

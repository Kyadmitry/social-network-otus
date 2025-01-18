package com.example.socialnetwork.repository;

import com.example.socialnetwork.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    UUID save(User user);
    Optional<User> findById(UUID userId);
    Optional<User> findByEmail(String email);
}

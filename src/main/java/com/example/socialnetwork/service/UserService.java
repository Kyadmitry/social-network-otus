package com.example.socialnetwork.service;

import com.example.socialnetwork.entity.dto.UserProfileDto;
import com.example.socialnetwork.entity.dto.UserRegistrationDto;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    Optional<UserProfileDto> getUserById(UUID userId);
    UUID registerUser(UserRegistrationDto userRegistrationDto);
}

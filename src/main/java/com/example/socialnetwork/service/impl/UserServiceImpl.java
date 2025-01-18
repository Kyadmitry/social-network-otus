package com.example.socialnetwork.service.impl;

import com.example.socialnetwork.entity.User;
import com.example.socialnetwork.entity.dto.UserProfileDto;
import com.example.socialnetwork.entity.dto.UserRegistrationDto;
import com.example.socialnetwork.mapper.UserMapper;
import com.example.socialnetwork.repository.impl.UserRepositoryImpl;
import com.example.socialnetwork.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepositoryImpl userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepositoryImpl userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.userMapper = userMapper;
    }

    @Override
    public Optional<UserProfileDto> getUserById(UUID userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.map(userMapper::toUserProfileDto);
    }

    @Override
    public UUID registerUser(UserRegistrationDto userRegistrationDto) {
        String hashedPassword = passwordEncoder.encode(userRegistrationDto.getPassword());
        userRegistrationDto.setPassword(hashedPassword);
        return userRepository.save(userMapper.toUser(userRegistrationDto));
    }
}

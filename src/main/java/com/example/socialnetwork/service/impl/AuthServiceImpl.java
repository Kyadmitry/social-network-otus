package com.example.socialnetwork.service.impl;

import com.example.socialnetwork.entity.User;
import com.example.socialnetwork.entity.dto.UserLoginDto;
import com.example.socialnetwork.repository.impl.UserRepositoryImpl;
import com.example.socialnetwork.service.AuthService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepositoryImpl userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public boolean validateUser(UserLoginDto userLoginDto) {
        Optional<User> user = userRepository.findByEmail(userLoginDto.getEmail());
        return user.filter(
                value -> passwordEncoder.matches(userLoginDto.getPassword(), value.getPassword())
                ).isPresent();
    }
}

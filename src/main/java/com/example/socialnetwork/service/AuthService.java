package com.example.socialnetwork.service;

import com.example.socialnetwork.entity.dto.UserLoginDto;

public interface AuthService {
    boolean validateUser(UserLoginDto userLoginDto);
}

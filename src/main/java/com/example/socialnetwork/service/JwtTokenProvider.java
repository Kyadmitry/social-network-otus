package com.example.socialnetwork.service;

public interface JwtTokenProvider {
    String generateToken(String userId);
}

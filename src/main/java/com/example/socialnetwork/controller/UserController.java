package com.example.socialnetwork.controller;

import com.example.socialnetwork.entity.dto.UserProfileDto;
import com.example.socialnetwork.entity.dto.UserRegistrationDto;
import com.example.socialnetwork.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UUID> registerUser(@RequestBody UserRegistrationDto userRegistrationDto) {
        UUID userId = userService.registerUser(userRegistrationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userId);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserProfileDto> getUserById(@PathVariable UUID id) {
        Optional<UserProfileDto> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}

package com.example.socialnetwork.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends UserBaseInfo {
    private UUID id;
    private String password;
}



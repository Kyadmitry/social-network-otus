package com.example.socialnetwork.entity;

import com.example.socialnetwork.entity.enums.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public abstract class UserBaseInfo {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;
    private String interests;
    private String city;
    private String email;
}
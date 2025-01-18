package com.example.socialnetwork.entity.dto;

import com.example.socialnetwork.entity.UserBaseInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserRegistrationDto extends UserBaseInfo {
    private String password;
}

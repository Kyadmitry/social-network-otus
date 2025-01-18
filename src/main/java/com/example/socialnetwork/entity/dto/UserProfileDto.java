package com.example.socialnetwork.entity.dto;

import com.example.socialnetwork.entity.UserBaseInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserProfileDto extends UserBaseInfo {
    private UUID id;
}
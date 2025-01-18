package com.example.socialnetwork.mapper;

import com.example.socialnetwork.entity.User;
import com.example.socialnetwork.entity.dto.UserProfileDto;
import com.example.socialnetwork.entity.dto.UserRegistrationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserRegistrationDto userRegistrationDto);

    UserProfileDto toUserProfileDto(User user);
}

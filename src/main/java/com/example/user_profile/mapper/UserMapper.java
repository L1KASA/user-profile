package com.example.user_profile.mapper;

import com.example.user_profile.dto.UserDto;
import com.example.user_profile.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {

        return new UserDto(

                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getGender(),
                user.getDateOfBirthday(),
                user.getAge()

        );

    }

    public static User mapToUser(UserDto userDto) {

        return new User(

                userDto.getId(),
                userDto.getName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getGender(),
                userDto.getDateOfBirthday(),
                userDto.getAge()

        );
    }

}

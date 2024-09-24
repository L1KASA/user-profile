package com.example.user_profile.mapper;

import com.example.user_profile.dto.UserDto;
import com.example.user_profile.entity.User;

import java.util.ArrayList;
import java.util.HashSet;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {

        return new UserDto(

                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getGender(),
                user.getDateOfBirthday(),
                user.getAge(),

                new ArrayList<>()
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
                userDto.getAge(),

                userDto.getTickets() != null ? new HashSet<>(userDto.getTickets().stream()
                        .map(TicketMapper::mapToTicket)
                        .toList()) : new HashSet<>()
        );
    }

}

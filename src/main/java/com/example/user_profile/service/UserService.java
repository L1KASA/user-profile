package com.example.user_profile.service;

import com.example.user_profile.dto.UserDto;
import java.util.List;

public interface UserService {

    UserDto addUser(UserDto userDto);

    UserDto getUserById(long id);
    
    List<UserDto> getAllUsers();

    UserDto updateUser(Long id, UserDto updatedUser);

    List<UserDto> searchUsersByName(String firstName, String lastName, String middleName, String surName);

    void deleteUser(Long id);

}

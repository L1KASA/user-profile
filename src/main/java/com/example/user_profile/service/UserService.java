package com.example.user_profile.service;

import com.example.user_profile.dto.UserDto;
import java.util.List;

public interface UserService {

    UserDto addUser(UserDto userDto);

    UserDto getUserById(long id);
    
    List<UserDto> getAllUsers();

    UserDto updateUser(Long id, UserDto updatedUser);

    void deleteUser(Long id);

}

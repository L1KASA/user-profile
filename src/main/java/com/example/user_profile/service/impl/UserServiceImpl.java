package com.example.user_profile.service.impl;

import com.example.user_profile.exception.ResourceNotFoundException;
import com.example.user_profile.mapper.UserMapper;
import com.example.user_profile.repository.UserRepository;
import com.example.user_profile.dto.UserDto;
import com.example.user_profile.entity.User;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import com.example.user_profile.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto addUser(UserDto userDto) {

        User todo = UserMapper.mapToUser(userDto);
        User savedTodo = userRepository.save(todo);

        return UserMapper.mapToUserDto(savedTodo);

    }

    @Override
    public UserDto getUserById(long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User is not exists with given id: " + id));
        return UserMapper.mapToUserDto(user);

    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());

    }

    @Override
    public UserDto updateUser(Long id, UserDto updatedUser) {

        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User is not exists with given id: " + id));

        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        user.setAge(updatedUser.getAge());
        user.setGender(updatedUser.getGender());
        user.setDateOfBirthday(updatedUser.getDateOfBirthday());

        User updatedUserObj = userRepository.save(user);

        return UserMapper.mapToUserDto(updatedUserObj);

    }

    @Override
    public List<UserDto> searchUsersByName(String firstName, String lastName, String middleName, String surName) {
        List<User> users = userRepository.findByName_FirstNameAndName_LastNameAndName_MiddleNameAndName_SurName(firstName, lastName, middleName, surName);
        return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {

        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User is not exists with given id: " + id)
        );
        userRepository.delete(user);

    }

}

package com.example.user_profile.service.impl;

import com.example.user_profile.exception.ResourceNotFoundException;
import com.example.user_profile.mapper.UserMapper;
import com.example.user_profile.repository.TodoRepository;
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

    private TodoRepository todoRepository;

    @Override
    public UserDto addUser(UserDto userDto) {

        User todo = UserMapper.mapToUser(userDto);
        User savedTodo = todoRepository.save(todo);

        return UserMapper.mapToUserDto(savedTodo);
    }

    @Override
    public UserDto getUserById(long id) {
        User user = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User is not exists with given id: " + id));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = todoRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id, UserDto updatedUser) {
        User user = todoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User is not exists with given id: " + id));

        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());

        User updatedUserObj = todoRepository.save(user);

        return UserMapper.mapToUserDto(updatedUserObj);
    }

}

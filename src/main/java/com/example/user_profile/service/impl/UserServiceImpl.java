package com.example.user_profile.service.impl;

import com.example.user_profile.mapper.UserMapper;
import com.example.user_profile.repository.TodoRepository;
import com.example.user_profile.dto.UserDto;
import com.example.user_profile.entity.User;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import com.example.user_profile.service.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private TodoRepository todoRepository;

    @Override
    public UserDto addTodo(UserDto userDto) {

        User todo = UserMapper.mapToUser(userDto);
        User savedTodo = todoRepository.save(todo);

        return UserMapper.mapToUserDto(savedTodo);


    }
}

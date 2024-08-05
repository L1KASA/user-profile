package com.example.user_profile.controller;

import com.example.user_profile.dto.UserDto;
import com.example.user_profile.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    // Build Add Users REST API
    @PostMapping
    public ResponseEntity<UserDto> addTodo(@RequestBody UserDto userDto){

        UserDto savedTodo = userService.addTodo(userDto);

        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

}
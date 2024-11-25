package com.example.user_profile.controller;

import com.example.user_profile.dto.UserDto;
import com.example.user_profile.entity.User;
import com.example.user_profile.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    // Build Add Users REST API
    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){

        UserDto savedTodo = userService.addUser(userDto);

        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);

    }

    //Build Get User REST API
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){

        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);

    }

    // Build Get All Users REST API
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){

        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);

    }

    // Build Update User REST API
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserDto updatedUser){

        UserDto userDto = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(userDto);

    }

    @GetMapping("/search")
    public ResponseEntity<List<UserDto>> searchUsersByName(@RequestBody UserDto userDto){
        List<UserDto> users = userService.searchUsersByName(
                userDto.getName().getFirstName(),
                userDto.getName().getLastName(),
                userDto.getName().getMiddleName(),
                userDto.getName().getSurName()
        );

        return ResponseEntity.ok(users);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){

        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully.");

    }

}
package com.example.user_profile.dto;

import com.example.user_profile.entity.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private Name name;

    private String email;

    private String password;

    private String gender;

    private Date dateOfBirthday;

    private long age;

}

package com.example.user_profile.repository;

import com.example.user_profile.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName_FirstNameAndName_LastNameAndName_MiddleNameAndName_SurName(String firstName, String lastName, String middleName, String surName);
}
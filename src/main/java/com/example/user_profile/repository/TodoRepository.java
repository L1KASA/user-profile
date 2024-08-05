package com.example.user_profile.repository;

import com.example.user_profile.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<User, Long> {
}
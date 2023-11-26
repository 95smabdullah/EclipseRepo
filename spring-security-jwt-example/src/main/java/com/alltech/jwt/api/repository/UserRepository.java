package com.alltech.jwt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alltech.jwt.api.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}

package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	User findByUserAndPassword(String user, String password);
}

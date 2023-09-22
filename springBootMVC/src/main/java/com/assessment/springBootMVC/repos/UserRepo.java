package com.assessment.springBootMVC.repos;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.springBootMVC.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	Optional<User> findByNameAndPass(String name, String pass);

}

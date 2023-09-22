package com.assessment.springBootMVC.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.springBootMVC.entities.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}

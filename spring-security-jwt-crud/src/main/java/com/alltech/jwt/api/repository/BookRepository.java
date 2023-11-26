package com.alltech.jwt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alltech.jwt.api.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer>  {

}

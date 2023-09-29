package com.assessment.productMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.productMS.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}

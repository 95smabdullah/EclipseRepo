package com.assessment.orderMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.orderMS.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

}

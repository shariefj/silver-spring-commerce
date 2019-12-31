package com.silver.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silver.commerce.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}

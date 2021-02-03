package com.accenture.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.ws.entity.Order;


public interface OrderRepository extends JpaRepository <Order, Long>{
}

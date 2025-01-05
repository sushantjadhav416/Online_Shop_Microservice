package com.shop.microservice.orderMicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.microservice.orderMicroservice.Modal.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}

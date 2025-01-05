package com.shop.microservice.orderMicroservice.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.microservice.orderMicroservice.Modal.Order;
import com.shop.microservice.orderMicroservice.dto.OrderRequest;
import com.shop.microservice.orderMicroservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService implements IOrderService {
	
	@Autowired
	public OrderRepository orderRepository;

	@Override
	public void placeOrder(OrderRequest orderRequest) {
		// TODO Auto-generated method stub
		 var order = mapToOrder(orderRequest);
         orderRepository.save(order);
	}

	@Override
	public Order mapToOrder(OrderRequest orderRequest) {
		// TODO Auto-generated method stub
		  Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        order.setSkuCode(orderRequest.skuCode());
        return order;
	}
}

package com.shop.microservice.orderMicroservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shop.microservice.orderMicroservice.dto.OrderRequest;
import com.shop.microservice.orderMicroservice.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
		try {
        orderService.placeOrder(orderRequest);
        return "Order Placed successfully";
		}
		catch (Exception e) {
			return e.getMessage();		
		}
    }
	
	
}

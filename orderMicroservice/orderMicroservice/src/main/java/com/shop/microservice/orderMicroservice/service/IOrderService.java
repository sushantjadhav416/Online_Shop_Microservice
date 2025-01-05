package com.shop.microservice.orderMicroservice.service;

import com.shop.microservice.orderMicroservice.Modal.Order;
import com.shop.microservice.orderMicroservice.dto.OrderRequest;

public interface IOrderService {
	
	 abstract void placeOrder(OrderRequest orderRequest);
	 
	 abstract Order mapToOrder(OrderRequest orderRequest);

}

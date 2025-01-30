package com.shop.microservice.orderMicroservice.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.microservice.orderMicroservice.Modal.Inventory;
import com.shop.microservice.orderMicroservice.Modal.Order;
import com.shop.microservice.orderMicroservice.client.InventoryClient;
import com.shop.microservice.orderMicroservice.dto.InventoryReq;
import com.shop.microservice.orderMicroservice.dto.InventoryResp;
import com.shop.microservice.orderMicroservice.dto.OrderRequest;
import com.shop.microservice.orderMicroservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService implements IOrderService {
	
	@Autowired
	public OrderRepository orderRepository;
	
	@Autowired
	public InventoryClient inventoryClient;

	@Override
	public void placeOrder(OrderRequest orderRequest) {
		// TODO Auto-generated method stub
		try {
		 boolean isStock = inventoryClient.isInStock(orderRequest.skuCode(),orderRequest.quantity());
		 if(isStock){
		    var order = mapToOrder(orderRequest);
		    updateQuantity(orderRequest.skuCode(), orderRequest.quantity());
            orderRepository.save(order);
		 }
		 else
		 {
			 throw new Exception("Product with Skucode " + orderRequest.skuCode() + "is not in stock");	 
		 }
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateQuantity(String skuCode,Integer quentity)
	{
		System.out.println("Updating the quantity in inventory");
		InventoryResp inventoryResp = inventoryClient.getInventoryInfo(skuCode);
		
		int updatedQuantity = inventoryResp.quantity()-quentity;
		
		InventoryResp updateResp = inventoryClient.updateInventoryInfo(new InventoryReq(inventoryResp.id(),inventoryResp.skuCode(),updatedQuantity));
	}

	@Override
	public Order mapToOrder(OrderRequest orderRequest) {
		// TODO Auto-generated method stub
		 Order order = new Order();
		try {
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        order.setSkuCode(orderRequest.skuCode());
        
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return order;
	}
}

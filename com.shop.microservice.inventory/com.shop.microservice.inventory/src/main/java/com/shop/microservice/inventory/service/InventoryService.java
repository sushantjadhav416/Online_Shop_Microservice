package com.shop.microservice.inventory.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.microservice.inventory.Modal.Inventory;
import com.shop.microservice.inventory.dto.InventoryReq;
import com.shop.microservice.inventory.dto.InventoryResp;
import com.shop.microservice.inventory.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

	@Autowired
    private InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode, Integer quantity) {
       // log.info(" Start -- Received request to check stock for skuCode {}, with quantity {}", skuCode, quantity);
        boolean isInStock = inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
       // log.info(" End -- Product with skuCode {}, and quantity {}, is in stock - {}", skuCode, quantity, isInStock);
        return isInStock;
    }
    
    public InventoryResp getProductinfo(String skuCode)
    {
    	 Inventory inventoryObj = inventoryRepository.findBySkuCode(skuCode);
		 
		 return new InventoryResp(inventoryObj.getId(),inventoryObj.getSkuCode(),inventoryObj.getQuantity());
    }
    
    public InventoryResp updateInventory(InventoryReq inventoryReq)
    {
    	Inventory inventory  = new Inventory();
    	inventory.setId(inventoryReq.id());
    	inventory.setSkuCode(inventoryReq.skuCode());
    	inventory.setQuantity(inventoryReq.quantity());
    	
    	inventoryRepository.save(inventory);
    	
    	return new InventoryResp(inventoryReq.id(),inventoryReq.skuCode(),inventoryReq.quantity());
    
    }
}
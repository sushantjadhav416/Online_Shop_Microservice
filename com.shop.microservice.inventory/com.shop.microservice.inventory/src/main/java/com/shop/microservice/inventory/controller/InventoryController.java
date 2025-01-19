package com.shop.microservice.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shop.microservice.inventory.dto.InventoryReq;
import com.shop.microservice.inventory.dto.InventoryResp;
import com.shop.microservice.inventory.service.InventoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
	@Autowired
    private final InventoryService inventoryService=null;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity) {
        return inventoryService.isInStock(skuCode, quantity);
    }
    
    @GetMapping("/{skuId}")
    @ResponseStatus(HttpStatus.OK)
    public InventoryResp getInventoryInfo(@PathVariable String skuId)
    {
    	return inventoryService.getProductinfo(skuId);
    }
    
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public InventoryResp updateInventoryInfo(@RequestBody InventoryReq inventoryReq)
    {
    	return inventoryService.updateInventory(inventoryReq);
    }
}
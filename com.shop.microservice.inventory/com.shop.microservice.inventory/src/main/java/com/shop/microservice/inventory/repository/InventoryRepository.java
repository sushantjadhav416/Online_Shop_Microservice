package com.shop.microservice.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.microservice.inventory.Modal.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);
    Inventory findBySkuCode(String skuCode);
 
}
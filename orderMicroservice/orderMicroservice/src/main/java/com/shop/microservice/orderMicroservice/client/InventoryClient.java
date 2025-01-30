package com.shop.microservice.orderMicroservice.client;

import org.bouncycastle.jcajce.provider.digest.Skein;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.microservice.orderMicroservice.dto.InventoryReq;
import com.shop.microservice.orderMicroservice.dto.InventoryResp;


@FeignClient(value = "inventory", url = "${inventory.url}")
public interface InventoryClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/inventory/{skuId}")
	InventoryResp getInventoryInfo(@PathVariable String skuId);
	
	@RequestMapping(method = RequestMethod.PUT, value = "/api/inventory")
	InventoryResp updateInventoryInfo(@RequestBody InventoryReq inventoryReq);

}

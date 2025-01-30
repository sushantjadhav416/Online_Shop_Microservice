package com.shop.microservice.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shop.microservice.product.dto.ProductRequest;
import com.shop.microservice.product.dto.ProductResponse;
import com.shop.microservice.product.service.ProductService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
	
	    @Autowired
	    private ProductService productService;
	 
	    @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
	        return productService.createProduct(productRequest);
	    }
	    
	    @GetMapping("/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public ProductResponse getProduct(String id) {
	        return productService.getProduct(id);
	    }
	 
	 
	    @GetMapping
	    @ResponseStatus(HttpStatus.OK)
	    public List<ProductResponse> getAllProducts() {
	        return productService.getProducts();
	    }
}

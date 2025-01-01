package com.shop.microservice.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.microservice.product.dto.ProductRequest;
import com.shop.microservice.product.dto.ProductResponse;
import com.shop.microservice.product.model.Product;
import com.shop.microservice.product.repository.IProductRepository;

import groovy.util.logging.Log;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	
	@Autowired
	private IProductRepository productRepository;
	
	public ProductResponse createProduct(ProductRequest productRequest) {
		 
	        Product product = new Product();
	        
	        product.setName(productRequest.name());
	        product.setDescription(productRequest.description());
	        product.setSkuCode(productRequest.skuCode());
	        product.setPrice(productRequest.price());
	        
	        productRepository.save(product);
	        
	        // log.info("Product created successfully");
	        return new ProductResponse(product.getId(), product.getName(), product.getDescription(),
	                product.getSkuCode(),
	                product.getPrice());
	    }
	 
	 public ProductResponse getProduct(String id)
	 {
		 Optional<Product> eproduct  = productRepository.findById(id);
		 
		 Product product = eproduct.get();
		 
		 return new ProductResponse(product.getId(), product.getName(), product.getDescription(),
                 product.getSkuCode(),
                 product.getPrice());
		
	 }
	 
	 public List<ProductResponse> getProducts()
	 {
		 return productRepository.findAll()
	                .stream()
	                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(),
	                        product.getSkuCode(),
	                        product.getPrice()))
	                .toList();
	 }
	 
	 
		 
		 
}

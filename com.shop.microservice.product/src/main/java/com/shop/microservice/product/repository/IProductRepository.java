package com.shop.microservice.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.shop.microservice.product.model.Product;


public interface IProductRepository extends MongoRepository<Product, String>{

}

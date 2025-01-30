package com.shop.microservice.orderMicroservice.dto;

import java.math.BigDecimal;

public record OrderRequest(Long id,String orderNum,String skuCode, BigDecimal price,Integer quantity ) {

}

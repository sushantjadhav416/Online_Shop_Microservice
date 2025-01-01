package com.shop.microservice.product;

import org.springframework.boot.SpringApplication;

public class TestSecureAp1Application {

	public static void main(String[] args) {
		SpringApplication.from(SecureAp1Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}

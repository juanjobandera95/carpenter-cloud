package com.carpentery.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.carpentery.springboot.controller"})
public class CarpenterCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarpenterCloudApplication.class, args);
	}

}
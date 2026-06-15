package com.sanosysalvos.refugio_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class RefugioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RefugioServiceApplication.class, args);
	}

}

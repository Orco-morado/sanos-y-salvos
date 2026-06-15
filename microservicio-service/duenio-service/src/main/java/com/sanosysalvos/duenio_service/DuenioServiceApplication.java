package com.sanosysalvos.duenio_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class DuenioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DuenioServiceApplication.class, args);
	}

}

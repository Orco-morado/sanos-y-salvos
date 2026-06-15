package com.sanosysalvos.mascota_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class MascotaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MascotaServiceApplication.class, args);
	}

}

package com.service.historial_mascota_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class HistorialMascotaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HistorialMascotaServiceApplication.class, args);
	}
}
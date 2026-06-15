package com.sanosysalvos.reporte_avistamiento_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class ReporteAvistamientoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReporteAvistamientoServiceApplication.class, args);
	}

}

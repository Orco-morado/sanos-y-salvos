package com.service.historial_mascota_service.Client;
import com.service.historial_mascota_service.dto.MascotaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MascotaClient {
    @Autowired
    private WebClient webClient;

    public MascotaDTO obtenerMascota(Integer idMascota) {
        return webClient
                .get()
                .uri("/api/v1/mascotas/{id}", idMascota)
                .retrieve()
                .bodyToMono(MascotaDTO.class)
                .block();
    }
}

package com.sanosysalvos.veterinaria_service.client;

import com.sanosysalvos.veterinaria_service.dto.ComunaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ComunaClient {
    @Autowired
    private WebClient webClient;

    public ComunaDTO obtenerComuna(Integer id){
        return webClient
                .get()
                .uri("/api/v1/comunas/{id}",id)
                .retrieve()
                .bodyToMono(ComunaDTO.class)
                .block();

    }
}

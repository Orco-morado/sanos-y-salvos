package com.sanosysalvos.refugio_service.client;

import com.sanosysalvos.refugio_service.dto.ComunaDTO;
import com.sanosysalvos.refugio_service.dto.RefugioComunaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

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

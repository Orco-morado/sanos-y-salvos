package com.service.historial_mascota_service.dto;

import lombok.Data;

@Data
public class MascotaDTO {
    // Se llama solo 'id' para coincidir perfecto con tu mascota-service
    private Integer id;
    private String nombre;
    private Integer id_especie;
    private String raza;
    private Integer edad;
    private String sexo;
    private String descripcion;
    private boolean activo;
}
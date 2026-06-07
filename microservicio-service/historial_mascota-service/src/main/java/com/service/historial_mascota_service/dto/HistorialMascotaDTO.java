package com.service.historial_mascota_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HistorialMascotaDTO {

    // Lo transformamos para que en el JSON se vea como id_historial
    @JsonProperty("id_historial")
    private Integer idHistorial;

    @JsonProperty("descripcion_tratamientos")
    private String descripcionTratamientos;

    @JsonProperty("cant_vacunas")
    private Integer cantVacunas;

    @JsonProperty("des_estado_mascota")
    private String desEstadoMascota;

    private boolean estado;

    // Aquí es donde incrustamos el objeto completo de la mascota
    private MascotaDTO mascota;
}
package com.sanosysalvos.refugio_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RefugioComunaDTO {
    private Integer id;

    private String nombre;

    private String direccion;

    private String nombre_comuna;

    private int num_contacto_r;

    private String correo_r;

    private int capacidad_maxima;

    private boolean activo;

}

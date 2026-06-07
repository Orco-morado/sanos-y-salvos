package com.sanosysalvos.veterinaria_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VeterinariaComunaDTO {
    private Integer id;

    private String nombre;

    private String direccion;

    private int num_contacto_v;

    private String correo_v;

    private ComunaDTO comuna;
}

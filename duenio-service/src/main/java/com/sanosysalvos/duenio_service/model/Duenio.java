package com.sanosysalvos.duenio_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "duenio")
public class Duenio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "El run es obligatorio")
    private int rut;

    @NotBlank(message = "El digito verificador es obligatorio")
    @Size(max=1, message = "El digito verificador no puede superar mas de 1 caracteres")
    private char dv;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max=50, message = "El nombre no puede superar mas de 50 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max=50, message = "El nombre no puede superar mas de 50 caracteres")
    private String apellido;

    private int numero;

    private String direccion;

    private boolean activo;
}

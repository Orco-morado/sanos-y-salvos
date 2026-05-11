package com.sanosysalvos.veterinaria_service.model;

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
@Table(name = "veterinaria")
public class Veterinaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max=50, message = "El nombre no puede superar mas de 20 caracteres")
    private String nombre;

    @NotBlank(message = "La direccion es obligatoria")
    private String direccion;

    private String comuna;

    @NotNull(message = "El numero de contacto es obligatorio")
    private int num_contacto_v;

    @NotBlank(message = "El correo es obligatorio")
    private String correo_v;

    private boolean activo;
}

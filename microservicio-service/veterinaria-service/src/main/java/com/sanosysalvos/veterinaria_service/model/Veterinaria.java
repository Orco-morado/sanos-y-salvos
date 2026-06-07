package com.sanosysalvos.veterinaria_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
    private String nombre;

    @NotBlank(message = "La direccion es obligatoria")
    private String direccion;

    @NotNull(message = "El numero de contacto es obligatorio")
    private int num_contacto_v;

    @Email(message = "El correo es obligatorio")
    private String correo_v;

    private boolean activo;

    @ManyToOne
    @JoinColumn(name="id_tipovet")
    private Tipo tipo;
}

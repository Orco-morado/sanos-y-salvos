package com.sanosysalvos.mascota_service.model;

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
@Table(name="mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Debes de insertar un nombre")
    private String nombre;


    @NotBlank(message = "Debes de insertar una raza")
    private String raza;

    @NotNull(message = "Debes de insertar una edad")
    private int edad;


    private char sexo;

    @NotBlank(message = "Debes de insertar una descripcion que ayude a identificar a su mascota")
    private String descripcion;

    private boolean activo;

    @ManyToOne
    @JoinColumn(name="id_especie")
    private Especie especie;

}

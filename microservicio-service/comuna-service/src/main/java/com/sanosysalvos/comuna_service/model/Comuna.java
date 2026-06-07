package com.sanosysalvos.comuna_service.model;

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
@Table(name = "comuna")
public class Comuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comuna")
    private Integer id;

    @Column(name = "nombre_comuna")
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Column(name = "cod_postal")
    @NotNull(message = "El codigo postal es obligatorio")
    private int codigo;

    private boolean activo;


}

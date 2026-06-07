package com.service.detalles_encuentro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detalles_encuentro")
public class DetallesEncuentro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_informe")
    private Integer idInforme;

    @NotNull(message = "La fecha del encuentro es obligatoria")
    @Column(name = "fecha_encuentro")
    private LocalDate fechaEncuentro;

    @NotBlank(message = "Los detalles de la mascota son obligatorios")
    @Column(name = "detalles_mascota")
    private String detallesMascota;

    @NotBlank(message = "La descripción para el encuentro es obligatoria")
    @Column(name = "descripcion_para_encuentro")
    private String descripcionParaEncuentro;

    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;
}
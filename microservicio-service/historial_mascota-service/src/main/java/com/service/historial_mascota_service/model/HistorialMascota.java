package com.service.historial_mascota_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "historial_mascota")

public class HistorialMascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Integer idHistorial;

    @NotBlank(message = "La descripción de los tratamientos es obligatoria")
    @Column(name = "descripcion_tratamientos")
    private String descripcionTratamientos;

    @NotNull(message = "La cantidad de vacunas es obligatoria")
    @Column(name = "cant_vacunas")
    private Integer cantVacunas;

    @NotBlank(message = "La descripción del estado de la mascota es obligatoria")
    @Column(name = "des_estado_mascota")
    private String desEstadoMascota;

    private boolean estado;

    @Column(name = "id_mascota")
    private Integer idMascota;
}
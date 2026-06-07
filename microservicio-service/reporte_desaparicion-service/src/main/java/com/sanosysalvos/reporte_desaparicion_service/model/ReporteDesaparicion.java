package com.sanosysalvos.reporte_desaparicion_service.model;

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
@Table(name = "reporteDesaparicion")
public class ReporteDesaparicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "El ID del dueño es obligatorio")
    private Integer id_duenio;

    @NotBlank(message = "El nombre de la mascota es obligatorio")
    private String nombre_mascota   ;

    @NotNull(message = "La fecha de desaparición es obligatoria")
    private LocalDate fecha;

    @NotNull(message = "El número del dueño es obligatorio")
    private Integer numero_duenio;

    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;

    @NotBlank(message = "El tipo de mascota es obligatorio")
    private String tipo_mascota;

    private boolean activo;
}

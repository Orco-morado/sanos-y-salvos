package com.sanosysalvos.reporte_avistamiento_service.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
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
@Table(name = "reporte_avistamiento")
public class ReporteAvistamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avistamiento")
    private Integer idAvistamiento;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @NotBlank(message = "La dirección del avistamiento es obligatoria")
    @Column(name = "direccion_avistamiento")
    private String direccionAvistamiento;

    @NotBlank(message = "El nombre de la persona es obligatorio")
    @Column(name = "persona_avistamiento")
    private String personaAvistamiento;

    @NotNull(message = "La fecha del avistamiento es obligatoria")
    @Column(name = "fecha_avistamiento")
    private LocalDate fechaAvistamiento;

    // En tu SQL es un tinyint(1), lo cual Spring mapea perfectamente a un boolean
    @Column(name = "estado_avistamiento")
    private boolean estadoAvistamiento;
}

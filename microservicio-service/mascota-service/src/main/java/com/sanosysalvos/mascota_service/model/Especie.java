package com.sanosysalvos.mascota_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="especie")
public class Especie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_especie;

    @NotBlank(message = "Debes de insertar un nombre")
    private String nombre_especie;

    private boolean activo;

    @JsonIgnore
    @OneToMany(mappedBy = "especie", cascade = CascadeType.ALL)
    private List<Mascota> mascotas;
}

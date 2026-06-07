package com.sanosysalvos.refugio_service.model;

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
@Table(name = "tipo_refugio")
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo;

    @NotBlank(message = "El tipo es obligatorio")
    private String tipo;

    private boolean activo;

    @JsonIgnore
    @OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL)
    private List<Refugio> refugios;
}

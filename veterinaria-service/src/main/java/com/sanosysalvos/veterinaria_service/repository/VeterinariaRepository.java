package com.sanosysalvos.veterinaria_service.repository;

import com.sanosysalvos.veterinaria_service.model.Veterinaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VeterinariaRepository extends JpaRepository<Veterinaria, Integer> {

    @Query(value = "SELECT * FROM veterinaria WHERE activo = TRUE",nativeQuery = true)
    List<Veterinaria> finVeterinariaActiva();
}

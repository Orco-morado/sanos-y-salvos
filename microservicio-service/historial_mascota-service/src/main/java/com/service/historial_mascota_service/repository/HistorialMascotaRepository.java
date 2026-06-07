package com.service.historial_mascota_service.repository;

import com.service.historial_mascota_service.model.HistorialMascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistorialMascotaRepository extends JpaRepository<HistorialMascota, Integer> {

    // En MySQL el tinyint(1) usa 1 para TRUE
    @Query(value = "SELECT * FROM historial_mascota WHERE estado = 1", nativeQuery = true)
    List<HistorialMascota> findHistorialesActivos();
}
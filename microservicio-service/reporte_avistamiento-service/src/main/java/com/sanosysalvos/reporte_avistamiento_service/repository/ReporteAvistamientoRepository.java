package com.sanosysalvos.reporte_avistamiento_service.repository;

import com.sanosysalvos.reporte_avistamiento_service.model.ReporteAvistamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReporteAvistamientoRepository extends JpaRepository<ReporteAvistamiento, Integer>{
    // El 1 representa TRUE en la columna tinyint de tu base de datos
    @Query(value = "SELECT * FROM reporte_avistamiento WHERE estado_avistamiento = 1", nativeQuery = true)
    List<ReporteAvistamiento> findAvistamientosActivos();
}


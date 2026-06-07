package com.sanosysalvos.reporte_desaparicion_service.repository;

import com.sanosysalvos.reporte_desaparicion_service.model.ReporteDesaparicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReporteDesaparicionRepository extends JpaRepository<ReporteDesaparicion, Integer> {

    @Query(value = "SELECT * FROM reporte_desaparicion WHERE activo = TRUE", nativeQuery = true)
    List<ReporteDesaparicion> findReportesActivos();

}

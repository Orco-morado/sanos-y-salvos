package com.sanosysalvos.comuna_service.repository;

import com.sanosysalvos.comuna_service.model.Comuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComunaRepository extends JpaRepository<Comuna, Integer> {

    @Query(value = "SELECT * FROM comuna WHERE activo = TRUE",nativeQuery = true)
    List<Comuna> finComunaActiva();
}

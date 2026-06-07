package com.sanosysalvos.refugio_service.repository;

import com.sanosysalvos.refugio_service.model.Refugio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RefugioRepository extends JpaRepository<Refugio, Integer> {

    @Query(value = "SELECT * FROM refugio WHERE activo = TRUE",nativeQuery = true)
    List<Refugio> finRefugioActivo();

}

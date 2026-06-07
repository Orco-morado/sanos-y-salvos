package com.sanosysalvos.duenio_service.repository;

import com.sanosysalvos.duenio_service.model.Duenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DuenioRepository extends JpaRepository<Duenio, Integer> {

    @Query("SELECT r FROM Duenio r WHERE r.activo = TRUE")
    List<Duenio> findDueniosActivos();

}

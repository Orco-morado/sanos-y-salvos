package com.sanosysalvos.mascota_service.repository;


import com.sanosysalvos.mascota_service.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

    @Query("SELECT r FROM Mascota r WHERE r.activo = TRUE")
    List<Mascota> findMascotasActivas();
}

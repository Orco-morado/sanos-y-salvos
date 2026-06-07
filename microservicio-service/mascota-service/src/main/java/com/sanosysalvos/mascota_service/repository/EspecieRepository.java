package com.sanosysalvos.mascota_service.repository;

import com.sanosysalvos.mascota_service.model.Especie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecieRepository extends JpaRepository<Especie, Integer> {
}

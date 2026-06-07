package com.sanosysalvos.hallador_service.repository;

import com.sanosysalvos.hallador_service.model.Hallador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HalladorRepository extends JpaRepository<Hallador,Integer> {
}

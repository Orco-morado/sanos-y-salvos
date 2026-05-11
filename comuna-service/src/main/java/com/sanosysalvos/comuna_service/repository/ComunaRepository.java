package com.sanosysalvos.comuna_service.repository;

import com.sanosysalvos.comuna_service.model.Comuna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComunaRepository extends JpaRepository<Comuna, Integer> {
}

package com.sanosysalvos.duenio_service.repository;

import com.sanosysalvos.duenio_service.model.Duenio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DuenioRepository extends JpaRepository<Duenio, Integer> {
}

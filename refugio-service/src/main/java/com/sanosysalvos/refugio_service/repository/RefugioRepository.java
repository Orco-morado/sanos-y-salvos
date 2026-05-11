package com.sanosysalvos.refugio_service.repository;

import com.sanosysalvos.refugio_service.model.Refugio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefugioRepository extends JpaRepository<Refugio, Integer> {
}

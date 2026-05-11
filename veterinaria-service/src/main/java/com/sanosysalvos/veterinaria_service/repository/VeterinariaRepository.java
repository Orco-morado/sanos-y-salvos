package com.sanosysalvos.veterinaria_service.repository;

import com.sanosysalvos.veterinaria_service.model.Veterinaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinariaRepository extends JpaRepository<Veterinaria, Integer> {
}

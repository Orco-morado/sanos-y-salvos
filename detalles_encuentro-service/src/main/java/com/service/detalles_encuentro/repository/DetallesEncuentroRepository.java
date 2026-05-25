package com.service.detalles_encuentro.repository;

import com.service.detalles_encuentro.model.DetallesEncuentro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallesEncuentroRepository extends JpaRepository<DetallesEncuentro, Integer> {
}
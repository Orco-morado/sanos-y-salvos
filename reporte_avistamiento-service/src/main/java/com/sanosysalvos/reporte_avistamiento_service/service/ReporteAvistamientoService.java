package com.sanosysalvos.reporte_avistamiento_service.service;

import com.sanosysalvos.reporte_avistamiento_service.model.ReporteAvistamiento;
import com.sanosysalvos.reporte_avistamiento_service.repository.ReporteAvistamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReporteAvistamientoService {
    @Autowired
    private ReporteAvistamientoRepository repository;

    public List<ReporteAvistamiento> getAvistamientos() {
        return repository.findAll();
    }

    public Optional<ReporteAvistamiento> getAvistamiento(Integer id) {
        return repository.findById(id);
    }

    public ReporteAvistamiento saveAvistamiento(ReporteAvistamiento avistamiento) {
        return repository.save(avistamiento);
    }

    public void delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Avistamiento no encontrado");
        }
    }

    public List<ReporteAvistamiento> getAvistamientosActivos() {
        return repository.findAvistamientosActivos();
    }
}

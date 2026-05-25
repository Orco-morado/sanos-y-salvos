package com.service.historial_mascota_service.service;

import com.service.historial_mascota_service.model.HistorialMascota;
import com.service.historial_mascota_service.repository.HistorialMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialMascotaService {

    @Autowired
    private HistorialMascotaRepository repository;

    public List<HistorialMascota> listarTodos() {
        return repository.findAll();
    }

    public List<HistorialMascota> listarActivos() {
        return repository.findHistorialesActivos();
    }

    public Optional<HistorialMascota> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public HistorialMascota guardar(HistorialMascota historial) {
        return repository.save(historial);
    }

    public void eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Historial no encontrado");
        }
    }
}
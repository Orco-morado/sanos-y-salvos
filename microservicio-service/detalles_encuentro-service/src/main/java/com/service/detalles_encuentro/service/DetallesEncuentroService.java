package com.service.detalles_encuentro.service;

import com.service.detalles_encuentro.model.DetallesEncuentro;
import com.service.detalles_encuentro.repository.DetallesEncuentroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallesEncuentroService {

    @Autowired
    private DetallesEncuentroRepository repository;

    public List<DetallesEncuentro> listarTodos() {
        return repository.findAll();
    }

    public Optional<DetallesEncuentro> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public DetallesEncuentro guardar(DetallesEncuentro detalle) {
        return repository.save(detalle);
    }

    public void eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Detalle de encuentro no encontrado");
        }
    }
}
package com.sanosysalvos.veterinaria_service.service;

import com.sanosysalvos.veterinaria_service.model.Tipo;
import com.sanosysalvos.veterinaria_service.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoService {
    @Autowired
    private TipoRepository repository;

    public List<Tipo> getTipos(){
        return repository.findAll();
    }

    public Optional<Tipo> getTipo(Integer id){
        return repository.findById(id);
    }

    public Tipo saveTipo(Tipo t){
        return repository.save(t);
    }

    public void delete(Integer id){
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new RuntimeException("No encontrado");
    }
}

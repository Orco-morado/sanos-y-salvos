package com.sanosysalvos.hallador_service.service;

import com.sanosysalvos.hallador_service.model.Hallador;
import com.sanosysalvos.hallador_service.repository.HalladorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HalladorService {
    @Autowired
    private HalladorRepository repository;

    public List<Hallador> getHalladores(){
        return repository.findAll();
    }

    public Optional<Hallador> getHallador(Integer id){
        return repository.findById(id);
    }

    public Hallador saveHallador (Hallador ha){
        return repository.save(ha);
    }

    public void delete(Integer id){
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new RuntimeException("No encontrado");
    }
}

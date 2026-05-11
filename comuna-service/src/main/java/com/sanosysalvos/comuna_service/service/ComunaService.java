package com.sanosysalvos.comuna_service.service;

import com.sanosysalvos.comuna_service.model.Comuna;
import com.sanosysalvos.comuna_service.repository.ComunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComunaService {
    @Autowired
    private ComunaRepository repository;

    public List<Comuna> getComunas(){
        return repository.findAll();
    }

    public Optional<Comuna> getComuna(Integer id){
        return repository.findById(id);
    }

    public Comuna saveComuna(Comuna co){
        return repository.save(co);
    }

    public void delete(Integer id){
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new RuntimeException("No encontrado");
    }
}

package com.sanosysalvos.duenio_service.service;

import com.sanosysalvos.duenio_service.model.Duenio;
import com.sanosysalvos.duenio_service.repository.DuenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuenioService {
    @Autowired
    private DuenioRepository repository;

    public List<Duenio> getDuenios(){
        return repository.findAll();
    }

    public Optional<Duenio> getDuenio(Integer id){
        return repository.findById(id);
    }

    public Duenio saveDuenio(Duenio du){
        return repository.save(du);
    }

    public void delete(Integer id){
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new RuntimeException("No encontrado");
    }

    public List<Duenio> getDueniosActivos(){
        return repository.findDueniosActivos();
    }
}

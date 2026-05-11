package com.sanosysalvos.veterinaria_service.service;

import com.sanosysalvos.veterinaria_service.model.Veterinaria;
import com.sanosysalvos.veterinaria_service.repository.VeterinariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinariaService {
    @Autowired
    private VeterinariaRepository repository;

    public List<Veterinaria> getVeterinarias(){
        return repository.findAll();
    }

    public Optional<Veterinaria> getVeterianria(Integer id){
        return repository.findById(id);
    }

    public Veterinaria saveVeterinaria(Veterinaria ve){
        return repository.save(ve);
    }

    public void delete(Integer id){
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new RuntimeException("No encontrado");
    }
}

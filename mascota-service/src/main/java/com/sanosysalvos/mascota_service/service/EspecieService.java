package com.sanosysalvos.mascota_service.service;

import com.sanosysalvos.mascota_service.model.Especie;
import com.sanosysalvos.mascota_service.model.Mascota;
import com.sanosysalvos.mascota_service.repository.EspecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecieService {
    @Autowired
    private EspecieRepository repository;

    public List<Especie> getEspecies(){
        return repository.findAll();
    }

    public Optional<Especie> getEspecie(Integer id){
        return repository.findById(id);
    }

    public Especie saveEspecie(Especie e){return repository.save(e);}

    public void delete(Integer id){
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new RuntimeException("No encontrado");}
}

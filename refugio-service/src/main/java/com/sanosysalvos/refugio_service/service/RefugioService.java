package com.sanosysalvos.refugio_service.service;

import com.sanosysalvos.refugio_service.model.Refugio;
import com.sanosysalvos.refugio_service.repository.RefugioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefugioService {
    @Autowired
    private RefugioRepository repository;

    public List<Refugio> getRefugios(){
        return repository.findAll();
    }

    public Optional<Refugio> getRefugio(Integer id){
        return repository.findById(id);
    }

    public Refugio saveRefugio(Refugio re){
        return repository.save(re);
    }

    public void delete(Integer id){
        if(repository.existsById(id))
            repository.deleteById(id);
        else
           throw new RuntimeException("No encontrado");
    }

    public List<Refugio> getRefugiosActivos(){
        return repository.finRefugioActivo();
    }

}

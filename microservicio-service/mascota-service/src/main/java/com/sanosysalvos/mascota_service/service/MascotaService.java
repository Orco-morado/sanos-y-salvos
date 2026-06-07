package com.sanosysalvos.mascota_service.service;

import com.sanosysalvos.mascota_service.model.Mascota;
import com.sanosysalvos.mascota_service.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository repository;

    public List<Mascota> getMascotas(){
        return repository.findAll();
    }

    public Optional<Mascota> getMascota(Integer id){
        return repository.findById(id);
    }

    public Mascota saveMascota(Mascota ma){
        return repository.save(ma);
    }

    public Mascota updateMascota(Integer id, Mascota ma){
        Optional existe = getMascota(id);

        if(existe.isEmpty())
            throw new RuntimeException("No encontrado");
        else
            return repository.save(ma);
    }

    public void delete(Integer id){
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new RuntimeException("No encontrado");
    }

    public List<Mascota> getMascotasActivas(){
        return repository.findMascotasActivas();
    }
}

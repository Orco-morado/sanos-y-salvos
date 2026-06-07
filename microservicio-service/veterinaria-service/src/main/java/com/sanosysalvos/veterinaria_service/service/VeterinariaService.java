package com.sanosysalvos.veterinaria_service.service;

import com.sanosysalvos.veterinaria_service.client.ComunaClient;
import com.sanosysalvos.veterinaria_service.dto.ComunaDTO;
import com.sanosysalvos.veterinaria_service.dto.VeterinariaComunaDTO;
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
    @Autowired
    private ComunaClient comunaClient;

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

    public List<Veterinaria> getVeterinariasActivas(){
        return repository.finVeterinariaActiva();
    }

    public VeterinariaComunaDTO getVeterinariaComunaDTO(Integer id){
        Veterinaria veterinaria=
                repository.findById(id).orElse(null);

        ComunaDTO comuna=
                comunaClient.obtenerComuna(id);

        VeterinariaComunaDTO dto= new VeterinariaComunaDTO();
        dto.setId(veterinaria.getId());
        dto.setNombre(veterinaria.getNombre());
        dto.setDireccion(veterinaria.getDireccion());
        dto.setCorreo_v(veterinaria.getCorreo_v());
        dto.setNum_contacto_v(veterinaria.getNum_contacto_v());
        dto.setComuna(comuna);

        return dto;

    }
}

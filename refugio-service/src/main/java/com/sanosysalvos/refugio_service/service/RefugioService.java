package com.sanosysalvos.refugio_service.service;

import com.sanosysalvos.refugio_service.client.ComunaClient;
import com.sanosysalvos.refugio_service.dto.ComunaDTO;
import com.sanosysalvos.refugio_service.dto.RefugioComunaDTO;
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
    @Autowired
    private ComunaClient comunaClient;

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

    public RefugioComunaDTO getRefugioComunaDTO(Integer id){
        Refugio refugio=
            repository.findById(id).orElse(null);

        ComunaDTO comuna=
                comunaClient.obtenerComuna(id);

        RefugioComunaDTO dto= new RefugioComunaDTO();
        dto.setId(refugio.getId());
        dto.setNombre(refugio.getNombre());
        dto.setDireccion(refugio.getDireccion());
        dto.setCorreo_r(refugio.getCorreo_r());
        dto.setNum_contacto_r(refugio.getNum_contacto_r());
        dto.setCapacidad_maxima(refugio.getCapacidad_maxima());
        dto.setComuna(comuna);

        return dto;

    }

}

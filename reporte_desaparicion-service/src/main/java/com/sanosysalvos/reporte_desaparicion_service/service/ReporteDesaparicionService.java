package com.sanosysalvos.reporte_desaparicion_service.service;

import com.sanosysalvos.reporte_desaparicion_service.model.ReporteDesaparicion;
import com.sanosysalvos.reporte_desaparicion_service.repository.ReporteDesaparicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReporteDesaparicionService {
    @Autowired
    private ReporteDesaparicionRepository repository;

    public List<ReporteDesaparicion> getReporte(){
        return repository.findAll();
    }

    public Optional<ReporteDesaparicion> getReporte(Integer id){
        return repository.findById(id);
    }

    public ReporteDesaparicion saveReporte(ReporteDesaparicion re){
        return repository.save(re);
    }

    public void delete(Integer id){
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new RuntimeException("No encontrado");
    }

    public List<ReporteDesaparicion> getReportesActivos(){

        // Usamos el método personalizado que creamos en el repositorio
        return repository.findReportesActivos();
    }

}



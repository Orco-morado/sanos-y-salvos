package com.service.historial_mascota_service.service;

import com.service.historial_mascota_service.Client.MascotaClient;
import com.service.historial_mascota_service.dto.HistorialMascotaDTO;
import com.service.historial_mascota_service.dto.MascotaDTO;

import com.service.historial_mascota_service.model.HistorialMascota;
import com.service.historial_mascota_service.repository.HistorialMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialMascotaService {

    @Autowired
    private HistorialMascotaRepository repository;

    @Autowired
    private MascotaClient mascotaClient;

    public List<HistorialMascota> listarTodos() {
        return repository.findAll();
    }

    public List<HistorialMascota> listarActivos() {
        return repository.findHistorialesActivos();
    }

    public Optional<HistorialMascota> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public HistorialMascota guardar(HistorialMascota historial) {
        return repository.save(historial);
    }

    public void eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Historial no encontrado");
        }
    }


    public HistorialMascotaDTO getHistorialCompleto(Integer idHistorial) {
        Optional<HistorialMascota> historialOpt = buscarPorId(idHistorial);

        if (historialOpt.isPresent()) {
            HistorialMascota historial = historialOpt.get();
            HistorialMascotaDTO dto = new HistorialMascotaDTO();

            // Pasamos los datos del modelo al DTO
            dto.setIdHistorial(historial.getIdHistorial());
            dto.setDescripcionTratamientos(historial.getDescripcionTratamientos());
            dto.setCantVacunas(historial.getCantVacunas());
            dto.setDesEstadoMascota(historial.getDesEstadoMascota());
            dto.setEstado(historial.isEstado());

            if (historial.getIdMascota() != null) {
                try {
                    MascotaDTO mascota = mascotaClient.obtenerMascota(historial.getIdMascota());
                    dto.setMascota(mascota);
                } catch (Exception e) {
                    System.err.println("Error al conectar con mascota-service: " + e.getMessage());
                }
            }
            return dto;
        }
        return null;
    }
}
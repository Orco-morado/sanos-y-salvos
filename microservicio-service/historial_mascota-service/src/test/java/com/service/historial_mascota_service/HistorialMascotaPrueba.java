package com.service.historial_mascota_service;

import com.service.historial_mascota_service.model.HistorialMascota;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HistorialMascotaPrueba {

    @Test
    void crearHistorialMascota() {
        Faker faker = new Faker();
        HistorialMascota h = new HistorialMascota();

        h.setDescripcionTratamientos(faker.lorem().sentence());
        h.setCantVacunas(faker.number().numberBetween(0, 10));
        h.setDesEstadoMascota(faker.lorem().word());
        h.setEstado(true);
        h.setIdMascota(faker.number().numberBetween(1, 100));

        assertNotNull(h);
        assertNotNull(h.getDescripcionTratamientos());
        assertTrue(h.getCantVacunas() >= 0);
        assertTrue(h.isEstado());
    }
}

package com.sanosysalvos.reporte_avistamiento_service;

import com.sanosysalvos.reporte_avistamiento_service.model.ReporteAvistamiento;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ReporteAvistamientoPrueba {

    @Test
    void crearReporteAvistamiento() {
        Faker faker = new Faker();
        ReporteAvistamiento r = new ReporteAvistamiento();

        r.setDescripcion(faker.lorem().sentence());
        r.setDireccionAvistamiento(faker.address().streetAddress());
        r.setPersonaAvistamiento(faker.name().fullName());
        r.setFechaAvistamiento(LocalDate.now());
        r.setEstadoAvistamiento(true);

        assertNotNull(r);
        assertNotNull(r.getDescripcion());
        assertNotNull(r.getPersonaAvistamiento());
        assertTrue(r.isEstadoAvistamiento());
    }
}

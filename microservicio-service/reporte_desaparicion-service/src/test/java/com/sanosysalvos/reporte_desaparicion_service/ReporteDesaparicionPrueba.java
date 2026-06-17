package com.sanosysalvos.reporte_desaparicion_service;

import com.sanosysalvos.reporte_desaparicion_service.model.ReporteDesaparicion;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ReporteDesaparicionPrueba {

    @Test
    void crearReporteDesaparicion() {
        Faker faker = new Faker();
        ReporteDesaparicion r = new ReporteDesaparicion();

        r.setId_duenio(faker.number().numberBetween(1, 100));
        r.setNombre_mascota(faker.animal().name());
        r.setFecha(LocalDate.now());
        r.setNumero_duenio(faker.number().numberBetween(600000000,799999999));
        r.setDireccion(faker.address().streetAddress());
        r.setTipo_mascota("Perro");
        r.setActivo(true);

        assertNotNull(r);
        assertNotNull(r.getNombre_mascota());
        assertTrue(r.isActivo());
    }
}

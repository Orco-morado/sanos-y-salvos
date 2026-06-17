package com.sanosysalvos.hallador_service;

import com.sanosysalvos.hallador_service.model.Hallador;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HalladorPrueba {

    @Test
    void crearHallador() {
        Faker faker = new Faker();
        Hallador h = new Hallador();

        h.setNombre(faker.name().fullName());
        h.setRut(faker.number().numberBetween(10000000, 99999999));
        h.setActivo(true);

        assertNotNull(h);
        assertNotNull(h.getNombre());
        assertTrue(h.getRut() > 0);
        assertTrue(h.isActivo());
    }
}

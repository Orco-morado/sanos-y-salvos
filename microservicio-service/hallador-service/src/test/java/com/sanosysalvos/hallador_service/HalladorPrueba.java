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
        h.setActivo(true);

        assertNotNull(h);
        assertNotNull(h.getNombre());
        assertTrue(h.isActivo());
    }
}

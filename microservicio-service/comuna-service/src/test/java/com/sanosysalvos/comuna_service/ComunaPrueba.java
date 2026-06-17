package com.sanosysalvos.comuna_service;

import com.sanosysalvos.comuna_service.model.Comuna;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComunaPrueba {

    @Test
    void crearComuna() {
        Faker faker = new Faker();
        Comuna c = new Comuna();

        c.setNombre(faker.address().cityName());
        c.setCodigo(faker.number().numberBetween(1000, 99999));
        c.setActivo(true);

        assertNotNull(c);
        assertNotNull(c.getNombre());
        assertTrue(c.getCodigo() > 0);
        assertTrue(c.isActivo());
    }
}

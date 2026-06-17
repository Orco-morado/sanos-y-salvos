package com.sanosysalvos.duenio_service;

import com.sanosysalvos.duenio_service.model.Duenio;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DuenioPrueba {

    @Test
    void crearDuenio() {
        Faker faker = new Faker();
        Duenio d = new Duenio();

        d.setRut(faker.number().numberBetween(10000000, 99999999));
        d.setDv('K');
        d.setNombre(faker.name().firstName());
        d.setApellido(faker.name().lastName());
        d.setNumero(faker.number().numberBetween(600000000, 799999999));
        d.setDireccion(faker.address().streetAddress());
        d.setActivo(true);

        assertNotNull(d);
        assertTrue(d.getRut() > 0);
        assertNotNull(d.getNombre());
        assertNotNull(d.getApellido());
        assertTrue(d.isActivo());
    }
}

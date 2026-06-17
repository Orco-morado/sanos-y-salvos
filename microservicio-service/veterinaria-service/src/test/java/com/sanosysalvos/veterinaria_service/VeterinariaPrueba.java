package com.sanosysalvos.veterinaria_service;

import com.sanosysalvos.veterinaria_service.model.Veterinaria;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VeterinariaPrueba {

    @Test
    void crearVeterinaria() {
        Faker faker = new Faker();
        Veterinaria v = new Veterinaria();

        v.setNombre(faker.company().name());
        v.setDireccion(faker.address().streetAddress());
        v.setNum_contacto_v(faker.number().numberBetween(900000000, 999999999));
        v.setCorreo_v(faker.internet().emailAddress());
        v.setActivo(true);

        assertNotNull(v);
        assertNotNull(v.getNombre());
        assertTrue(v.isActivo());
    }
}

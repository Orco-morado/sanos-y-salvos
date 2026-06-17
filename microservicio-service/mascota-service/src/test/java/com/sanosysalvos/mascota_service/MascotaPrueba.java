package com.sanosysalvos.mascota_service;

import com.sanosysalvos.mascota_service.model.Mascota;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MascotaPrueba {

    @Test
    void crearMascota() {
        Faker faker = new Faker();
        Mascota m = new Mascota();

        m.setNombre(faker.name().firstName());
        m.setRaza(faker.animal().name());
        m.setEdad(faker.number().numberBetween(1, 15));
        m.setSexo('M');
        m.setDescripcion(faker.lorem().sentence());
        m.setActivo(true);

        assertNotNull(m);
        assertNotNull(m.getNombre());
        assertTrue(m.getEdad() > 0);
        assertTrue(m.isActivo());
    }
}

package com.sanosysalvos.refugio_service;

import com.sanosysalvos.refugio_service.model.Refugio;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RefugioPrueba {

    @Test
    void crearRefugio() {
        Faker faker = new Faker();
        Refugio r = new Refugio();

        r.setNombre(faker.company().name());
        r.setDireccion(faker.address().streetAddress());
        r.setNum_contacto_r(faker.number().numberBetween(900000000, 999999999));
        r.setCorreo_r(faker.internet().emailAddress());
        r.setCapacidad_maxima(faker.number().numberBetween(1, 200));
        r.setActivo(true);

        assertNotNull(r);
        assertNotNull(r.getNombre());
        assertTrue(r.getCapacidad_maxima() > 0);
    }
}

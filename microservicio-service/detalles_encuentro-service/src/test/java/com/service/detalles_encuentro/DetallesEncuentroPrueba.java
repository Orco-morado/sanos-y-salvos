package com.service.detalles_encuentro;

import com.service.detalles_encuentro.model.DetallesEncuentro;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DetallesEncuentroPrueba {

    @Test
    void crearDetallesEncuentro() {
        Faker faker = new Faker();
        DetallesEncuentro d = new DetallesEncuentro();

        d.setFechaEncuentro(LocalDate.now());
        d.setDetallesMascota(faker.lorem().sentence());
        d.setDescripcionParaEncuentro(faker.lorem().sentence());
        d.setDireccion(faker.address().streetAddress());

        assertNotNull(d);
        assertNotNull(d.getFechaEncuentro());
        assertNotNull(d.getDetallesMascota());
        assertNotNull(d.getDireccion());
    }
}

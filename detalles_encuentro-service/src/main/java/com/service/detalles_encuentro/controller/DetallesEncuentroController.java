package com.service.detalles_encuentro.controller;

import com.service.detalles_encuentro.model.DetallesEncuentro;
import com.service.detalles_encuentro.service.DetallesEncuentroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/detalles-encuentro")
public class DetallesEncuentroController {

    @Autowired
    private DetallesEncuentroService service;

    @GetMapping
    public ResponseEntity<List<DetallesEncuentro>> listar() {
        List<DetallesEncuentro> detalles = service.listarTodos();
        if (detalles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallesEncuentro> buscarPorId(@PathVariable Integer id) {
        Optional<DetallesEncuentro> detalle = service.buscarPorId(id);
        if (detalle.isPresent()) {
            return ResponseEntity.ok(detalle.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DetallesEncuentro> guardar(@Valid @RequestBody DetallesEncuentro detalle) {
        DetallesEncuentro nuevoDetalle = service.guardar(detalle);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDetalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallesEncuentro> editar(@PathVariable Integer id, @Valid @RequestBody DetallesEncuentro detalle) {
        Optional<DetallesEncuentro> existe = service.buscarPorId(id);

        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        detalle.setIdInforme(id);
        DetallesEncuentro actualizado = service.guardar(detalle);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errores);
    }
}
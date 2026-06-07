package com.sanosysalvos.reporte_avistamiento_service.controller;

import com.sanosysalvos.reporte_avistamiento_service.model.ReporteAvistamiento;
import com.sanosysalvos.reporte_avistamiento_service.service.ReporteAvistamientoService;
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
@RequestMapping("api/v1/reporte-avistamiento")
public class ReporteAvistamientocontroller {
    @Autowired
    private ReporteAvistamientoService service; // Aquí agregué el nombre "service" que faltaba

    // @GetMapping
    public ResponseEntity<List<ReporteAvistamiento>> listar() {
        List<ReporteAvistamiento> avistamientos = service.getAvistamientos();
        if (avistamientos.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(avistamientos);
    }

    @GetMapping
    public ResponseEntity<List<ReporteAvistamiento>> listarActivos() {
        List<ReporteAvistamiento> avistamientos = service.getAvistamientosActivos();
        if (avistamientos.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(avistamientos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReporteAvistamiento> buscarAvistamiento(@PathVariable Integer id) {
        Optional<ReporteAvistamiento> avistamiento = service.getAvistamiento(id);
        if (avistamiento.isPresent())
            return ResponseEntity.ok(avistamiento.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ReporteAvistamiento> guardar(@Valid @RequestBody ReporteAvistamiento avistamiento) {
        ReporteAvistamiento nuevoAvistamiento = service.saveAvistamiento(avistamiento);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoAvistamiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReporteAvistamiento> editar(@PathVariable Integer id, @Valid @RequestBody ReporteAvistamiento avistamiento) {
        Optional<ReporteAvistamiento> existe = service.getAvistamiento(id);

        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        avistamiento.setIdAvistamiento(id);
        ReporteAvistamiento actualizar = service.saveAvistamiento(avistamiento);
        return ResponseEntity.ok(actualizar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            service.delete(id);
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

package com.service.historial_mascota_service.controller;

import com.service.historial_mascota_service.dto.HistorialMascotaDTO;
import com.service.historial_mascota_service.model.HistorialMascota;
import com.service.historial_mascota_service.service.HistorialMascotaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("api/v1/historial-mascota")
public class HistorialMascotaController {
    @Autowired
    private HistorialMascotaService service;
    //@GetMapping
    public ResponseEntity<List<HistorialMascota>> listar(){
        List<HistorialMascota> historiales = service.listarTodos();
        if(historiales.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(historiales);
    }

    @GetMapping
    public ResponseEntity<List<HistorialMascota>> getActivos(){
        List<HistorialMascota> historiales = service.listarActivos();
        if(historiales.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(historiales);
    }

    @GetMapping("/{id}")
    public EntityModel<HistorialMascota> getHistorial(@PathVariable Integer id){
        HistorialMascota historialMascota = service.buscarPorId(id).orElseThrow();
        EntityModel<HistorialMascota> model = EntityModel.of(historialMascota);

        model.add(
                linkTo(
                        methodOn(HistorialMascotaController.class).getHistorial(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(HistorialMascotaController.class).getActivos()
                ).withRel("Todos los Historiales de Mascotas")
        );

        return model;
    }
    /*public ResponseEntity<HistorialMascota> buscarporid(@PathVariable Integer id){
        Optional<HistorialMascota> historiales = service.buscarPorId(id);
        if(historiales.isPresent())
            return ResponseEntity.ok(historiales.get());
        else
            return ResponseEntity.notFound().build();
    }*/

    @PostMapping
    public ResponseEntity<HistorialMascota> guardar(@Valid @RequestBody HistorialMascota historial) {
        HistorialMascota nuevoHistorial = service.guardar(historial);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoHistorial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistorialMascota> editar(@PathVariable Integer id,@Valid @RequestBody HistorialMascota historial){
        Optional<HistorialMascota> existe = service.buscarPorId(id);

        if (existe.isEmpty()){
            return ResponseEntity.notFound().build();}

        historial.setIdHistorial(id);
        HistorialMascota actualizado = service.guardar(historial);
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
    @GetMapping("/{id}/completo")
    public ResponseEntity<HistorialMascotaDTO> obtenerHistorialConMascota(@PathVariable Integer id) {
        // Llama al método que creamos en el Service que usa el MascotaClient
        HistorialMascotaDTO dto = service.getHistorialCompleto(id);

        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

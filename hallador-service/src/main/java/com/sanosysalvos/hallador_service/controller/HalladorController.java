package com.sanosysalvos.hallador_service.controller;

import com.sanosysalvos.hallador_service.model.Hallador;
import com.sanosysalvos.hallador_service.service.HalladorService;
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
@RequestMapping("api/v1/halladores")
public class HalladorController {
    @Autowired
    private HalladorService service;
    @GetMapping
    public ResponseEntity<List<Hallador>> Listar() {
        List<Hallador> hallador = service.getHalladores();
        if (hallador.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(hallador);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hallador> buscarHallador(@PathVariable Integer id){
        Optional<Hallador> hallador= service.getHallador(id);
        if(hallador.isPresent())
            return ResponseEntity.ok(hallador.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Hallador> guardar(@Valid @RequestBody Hallador ha){
        Hallador hallador = service.saveHallador(ha);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(hallador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hallador> editar(@PathVariable Integer id, @Valid @RequestBody Hallador ha){
        Optional<Hallador> existe = service.getHallador(id);

        if (existe.isEmpty()){
            return ResponseEntity.notFound().build();}

        ha.setId(id);
        Hallador actualizar = service.saveHallador(ha);
        return ResponseEntity.ok(actualizar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        try{
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex){

        Map<String, String> errores = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errores) ;
    }
}

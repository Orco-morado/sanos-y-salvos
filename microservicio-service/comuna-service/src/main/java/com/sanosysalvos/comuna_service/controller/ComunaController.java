package com.sanosysalvos.comuna_service.controller;

import com.sanosysalvos.comuna_service.model.Comuna;
import com.sanosysalvos.comuna_service.service.ComunaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("api/v1/comunas")
@Tag(name = "Comunas", description = "Operaciones relacionadas con las comunas")
public class ComunaController {
    @Autowired
    private ComunaService service;

    //@GetMapping
    public ResponseEntity<List<Comuna>> listar(){
        List<Comuna> comuna = service.getComunas();

        if(comuna.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(comuna);
    }

    @Operation(summary = "Obtiene todos los detalles de las comunas")
    @GetMapping
    public ResponseEntity<List<Comuna>> listarAvtivas(){
        List<Comuna> comuna = service.getComunasActivas();

        if(comuna.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(comuna);
    }

    @Operation(summary = "Obtiene todos los detalles de una comuna em especifico")
    @GetMapping("/{id}")
    public ResponseEntity<Comuna> buscarComuna(@PathVariable Integer id){
        Optional<Comuna> comuna = service.getComuna(id);

        if(comuna.isPresent())
            return ResponseEntity.ok(comuna.get());
        else
            return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Añades comunas a la base de datos")
    @PostMapping
    public ResponseEntity<Comuna> guardarComuna(@Valid @RequestBody Comuna co){
        Comuna comuna = service.saveComuna(co);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(comuna);
    }

    @Operation(summary = "Modificas una comuna")
    @PutMapping("/{id}")
    public ResponseEntity<Comuna> editar(@PathVariable Integer id,@Valid @RequestBody Comuna co){
        Optional<Comuna> existe = service.getComuna(id);

        if (existe.isEmpty()){
            return ResponseEntity.notFound().build();}

        co.setId(id);
        Comuna actualizar = service.saveComuna(co);
        return ResponseEntity.ok(actualizar);
    }

    @Operation(summary = "Eliminas una comuna")
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

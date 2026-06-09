package com.sanosysalvos.veterinaria_service.controller;

import com.sanosysalvos.veterinaria_service.model.Tipo;
import com.sanosysalvos.veterinaria_service.service.TipoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("api/v1/tipos")
@Tag(name = "Tipos", description = "Operaciones relacionadas con los Tipos de Veterinarias")
public class TipoController {
    @Autowired
    private TipoService service;

    @Operation(summary = "Obtiene todos los detalles de los Tipos de Veterinarias")
    @GetMapping
    public ResponseEntity<List<Tipo>> getTipos(){
        List<Tipo> tipo = service.getTipos();
        if(tipo.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(tipo);
    }

    @Operation(summary = "Obtiene todos los detalles de un Tipo de Veterinaria en especifico")
    @GetMapping("/{id}")
    public EntityModel<Tipo> getTipo(@PathVariable Integer id){
        Tipo tipo = service.getTipo(id).orElseThrow();
        EntityModel<Tipo> model = EntityModel.of(tipo);

        model.add(
                linkTo(
                        methodOn(TipoController.class).getTipo(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(TipoController.class).getTipos()
                ).withRel("Todos los Tipos")
        );

        return model;
    }
    /*public ResponseEntity<Tipo> buscarVeterinaria(@PathVariable Integer id){
        Optional<Tipo> tipo = service.getTipo(id);
        if(tipo.isPresent())
            return ResponseEntity.ok(tipo.get());
        else
            return ResponseEntity.notFound().build();
    }*/

    @Operation(summary = "Añade un Tipo de Veterinaria")
    @PostMapping
    public ResponseEntity<Tipo> guardar(@Valid @RequestBody Tipo t){
        Tipo tipo = service.saveTipo(t);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(tipo);
    }

    @Operation(summary = "Modifica un Tipo de Veterinaria")
    @PutMapping("/{id}")
    public ResponseEntity<Tipo> editar(@PathVariable Integer id,@Valid @RequestBody Tipo t){
        Optional<Tipo> existe = service.getTipo(id);

        if (existe.isEmpty()){
            return ResponseEntity.notFound().build();}

        t.setId_tipovet(id);
        Tipo actualizar = service.saveTipo(t);
        return ResponseEntity.ok(actualizar);
    }

    @Operation(summary = "Elimina un Tipo de Veterinaria")
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

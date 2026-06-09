package com.sanosysalvos.duenio_service.controller;

import com.sanosysalvos.duenio_service.model.Duenio;
import com.sanosysalvos.duenio_service.service.DuenioService;
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
@RequestMapping("api/v1/duenios")
@Tag(name = "Dueños", description = "Operaciones relacionadas con los Dueños")
public class DuenioController {
    @Autowired
    private DuenioService service;

    //@GetMapping
    public ResponseEntity<List<Duenio>> listar(){
        List<Duenio> duenio = service.getDuenios();

        if(duenio.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(duenio);
    }

    @Operation(summary = "Obtiene todos los detalles de los dueños")
    @GetMapping
    public ResponseEntity<List<Duenio>> getActivos(){
        List<Duenio> duenio = service.getDueniosActivos();

        if(duenio.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(duenio);
    }

    @Operation(summary = "Obtiene todos los detalles de un solo dueño")
    @GetMapping("/{id}")
    public EntityModel<Duenio> getDuenio(@PathVariable Integer id){
        Duenio comuna = service.getDuenio(id).orElseThrow();
        EntityModel<Duenio> model = EntityModel.of(comuna);

        model.add(
                linkTo(
                        methodOn(DuenioController.class).getDuenio(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(DuenioController.class).getActivos()
                ).withRel("Todos los Dueños")
        );

        return model;
    }
    /*public ResponseEntity<Duenio> buscarDuenio(@PathVariable Integer id){
        Optional<Duenio> duenio = service.getDuenio(id);

        if(duenio.isPresent())
            return ResponseEntity.ok(duenio.get());
        else
            return ResponseEntity.notFound().build();
    }*/

    @Operation(summary = "Añades dueños")
    @PostMapping
    public ResponseEntity<Duenio> guardarDuenio(@Valid @RequestBody Duenio du){
        Duenio duenio = service.saveDuenio(du);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(duenio);
    }


    @Operation(summary = "Modificas un dueño")
    @PutMapping("/{id}")
    public ResponseEntity<Duenio> editar(@PathVariable Integer id,@Valid @RequestBody Duenio du){
        Optional<Duenio> existe = service.getDuenio(id);

        if (existe.isEmpty()){
            return ResponseEntity.notFound().build();}

        du.setId(id);
        Duenio actualizar = service.saveDuenio(du);
        return ResponseEntity.ok(actualizar);
    }

    @Operation(summary = "Eliminas un dueño")
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

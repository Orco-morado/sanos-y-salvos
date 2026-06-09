package com.sanosysalvos.mascota_service.controller;

import com.sanosysalvos.mascota_service.model.Especie;
import com.sanosysalvos.mascota_service.service.EspecieService;
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
@RequestMapping("api/v1/especies")
@Tag(name = "Especies", description = "Operaciones relacionadas con las especies")
public class EspecieController {

    @Autowired
    private EspecieService service;

    @Operation(summary = "Obtiene todos los detalles de las especies")
    @GetMapping
    public ResponseEntity<List<Especie>> getEspecies(){
        List<Especie> especies = service.getEspecies();
        if(especies.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(especies);
    }

    @Operation(summary = "Obtiene todos los detalles de una especie en especifico")
    @GetMapping("/{id}")
    public EntityModel<Especie> getEspecie(@PathVariable Integer id){
        Especie especie = service.getEspecie(id).orElseThrow();
        EntityModel<Especie> model = EntityModel.of(especie);

        model.add(
                linkTo(
                        methodOn(EspecieController.class).getEspecie(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(EspecieController.class).getEspecies()
                ).withRel("Todas las Comunas")
        );

        return model;
    }
    /*public ResponseEntity<Especie> buscarEspecie(@PathVariable Integer id){
        Optional<Especie> especie = service.getEspecie(id);
        if(especie.isPresent())
            return ResponseEntity.ok(especie.get());
        else
            return ResponseEntity.notFound().build();
    }*/

    @Operation(summary = "Añades una especie")
    @PostMapping
    public ResponseEntity<Especie> guardar(@Valid @RequestBody Especie e){
        Especie especie = service.saveEspecie(e);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(especie);
    }

    @Operation(summary = "Modificas una especie")
    @PutMapping("/{id}")
    public ResponseEntity<Especie> editar(@PathVariable Integer id,@Valid @RequestBody Especie e){
        Optional<Especie> existe = service.getEspecie(id);

        if (existe.isEmpty()){
            return ResponseEntity.notFound().build();}

        e.setId_especie(id);
        Especie actualizar = service.saveEspecie(e);
        return ResponseEntity.ok(actualizar);
    }

    @Operation(summary = "Eliminas una especie")
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

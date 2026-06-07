package com.sanosysalvos.veterinaria_service.controller;

import com.sanosysalvos.veterinaria_service.dto.VeterinariaComunaDTO;
import com.sanosysalvos.veterinaria_service.model.Veterinaria;
import com.sanosysalvos.veterinaria_service.service.VeterinariaService;
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
@RequestMapping("api/v1/veterinarias")
@Tag(name = "Veterinarias", description = "Operaciones relacionadas con las Veterinarias")
public class VeterinariaController {
    @Autowired
    private VeterinariaService service;

    //@GetMapping
    public ResponseEntity<List<Veterinaria>> Listar(){
        List<Veterinaria> veterinaria = service.getVeterinarias();
        if(veterinaria.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(veterinaria);
    }

    @Operation(summary = "Obtiene todos los detalles de las veterinarias")
    @GetMapping
    public ResponseEntity<List<Veterinaria>> ListarActivas(){
        List<Veterinaria> veterinaria = service.getVeterinariasActivas();
        if(veterinaria.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(veterinaria);
    }

    @Operation(summary = "Obtiene todos los detalles de una sola veterinaria")
    @GetMapping("/{id}")
    public ResponseEntity<Veterinaria> buscarVeterinaria(@PathVariable Integer id){
        Optional<Veterinaria> veterinaria = service.getVeterianria(id);
        if(veterinaria.isPresent())
            return ResponseEntity.ok(veterinaria.get());
        else
            return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Añades veterinarias")
    @PostMapping
    public ResponseEntity<Veterinaria> guardar(@Valid @RequestBody Veterinaria ve){
        Veterinaria veterinaria = service.saveVeterinaria(ve);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(veterinaria);
    }

    @Operation(summary = "Modificas una veterinaria")
    @PutMapping("/{id}")
    public ResponseEntity<Veterinaria> editar(@PathVariable Integer id,@Valid @RequestBody Veterinaria ve){
        Optional<Veterinaria> existe = service.getVeterianria(id);

        if (existe.isEmpty()){
            return ResponseEntity.notFound().build();}

        ve.setId(id);
        Veterinaria actualizar = service.saveVeterinaria(ve);
        return ResponseEntity.ok(actualizar);
    }

    @Operation(summary = "Eliminas una veterinaria")
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

    @Operation(summary = "Obtiene todos los detalles de una solo veterinarias junto con su comuna asociada")
    @GetMapping("/comunas/{id}")
    public VeterinariaComunaDTO veterinariaConComuna(@PathVariable Integer id){
        return service.getVeterinariaComunaDTO(id);
    }
}

package com.sanosysalvos.mascota_service.controller;

import com.sanosysalvos.mascota_service.model.Mascota;
import com.sanosysalvos.mascota_service.service.MascotaService;
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
@RequestMapping("api/v1/mascotas")
@Tag(name = "Mascotas", description = "Operaciones relacionadas con las mascotas")
public class MascotaController {
    @Autowired
    private MascotaService service;

    //@GetMapping
    public ResponseEntity<List<Mascota>> Listar(){
        List<Mascota> mascota = service.getMascotas();
                if(mascota.isEmpty())
                    return ResponseEntity.noContent().build();
                else
                    return ResponseEntity.ok(mascota);
    }

    @Operation(summary = "Obtiene todos los detalles de las mascotas")
    @GetMapping
    public ResponseEntity<List<Mascota>> Listar2(){
        List<Mascota> mascota = service.getMascotasActivas();
        if(mascota.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(mascota);
    }

    @Operation(summary = "Obtiene todos los detalles de una mascota")
    @GetMapping("/{id}")
    public ResponseEntity<Mascota> buscarMascota(@PathVariable Integer id){
        Optional<Mascota> mascota = service.getMascota(id);
        if(mascota.isPresent())
            return ResponseEntity.ok(mascota.get());
        else
            return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Añade mascotas")
    @PostMapping
    public ResponseEntity<Mascota> guardar(@Valid @RequestBody Mascota ma){
        Mascota mascota = service.saveMascota(ma);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mascota);
    }

    @Operation(summary = "Modifica una mascota")
    @PutMapping("/{id}")
    public ResponseEntity<Mascota> editar(@PathVariable Integer id,@Valid @RequestBody Mascota ma){
        Optional<Mascota> existe = service.getMascota(id);

        if (existe.isEmpty()){
            return ResponseEntity.notFound().build();}

        ma.setId(id);
        Mascota actualizar = service.saveMascota(ma);
        return ResponseEntity.ok(actualizar);
    }

    @Operation(summary = "Elimina una mascota")
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

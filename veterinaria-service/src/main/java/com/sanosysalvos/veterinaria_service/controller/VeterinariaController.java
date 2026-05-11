package com.sanosysalvos.veterinaria_service.controller;

import com.sanosysalvos.veterinaria_service.model.Veterinaria;
import com.sanosysalvos.veterinaria_service.service.VeterinariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/veterinarias")
public class VeterinariaController {
    @Autowired
    private VeterinariaService service;

    @GetMapping
    public ResponseEntity<List<Veterinaria>> Listar(){
        List<Veterinaria> veterinaria = service.getVeterinarias();
        if(veterinaria.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(veterinaria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinaria> buscarVeterinaria(@PathVariable Integer id){
        Optional<Veterinaria> veterinaria = service.getVeterianria(id);
        if(veterinaria.isPresent())
            return ResponseEntity.ok(veterinaria.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Veterinaria> guardar(@RequestBody Veterinaria ve){
        Veterinaria veterinaria = service.saveVeterinaria(ve);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(veterinaria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veterinaria> editar(@PathVariable Integer id,@RequestBody Veterinaria ve){
        Optional<Veterinaria> existe = service.getVeterianria(id);

        if (existe.isEmpty()){
            return ResponseEntity.notFound().build();}

        ve.setId(id);
        Veterinaria actualizar = service.saveVeterinaria(ve);
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
}

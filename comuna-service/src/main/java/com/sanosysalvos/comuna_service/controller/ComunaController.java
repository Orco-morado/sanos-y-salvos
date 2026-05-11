package com.sanosysalvos.comuna_service.controller;

import com.sanosysalvos.comuna_service.model.Comuna;
import com.sanosysalvos.comuna_service.service.ComunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/comunas")
public class ComunaController {
    @Autowired
    private ComunaService service;

    @GetMapping
    public ResponseEntity<List<Comuna>> listar(){
        List<Comuna> comuna = service.getComunas();

        if(comuna.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(comuna);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comuna> buscarComuna(@PathVariable Integer id){
        Optional<Comuna> comuna = service.getComuna(id);

        if(comuna.isPresent())
            return ResponseEntity.ok(comuna.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Comuna> guardarComuna(@RequestBody Comuna co){
        Comuna comuna = service.saveComuna(co);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(comuna);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comuna> editar(@PathVariable Integer id,@RequestBody Comuna co){
        Optional<Comuna> existe = service.getComuna(id);

        if (existe.isEmpty()){
            return ResponseEntity.notFound().build();}

        co.setId(id);
        Comuna actualizar = service.saveComuna(co);
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

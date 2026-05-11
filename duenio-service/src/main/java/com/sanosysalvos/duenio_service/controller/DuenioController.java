package com.sanosysalvos.duenio_service.controller;

import com.sanosysalvos.duenio_service.model.Duenio;
import com.sanosysalvos.duenio_service.service.DuenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/duenios")
public class DuenioController {
    @Autowired
    private DuenioService service;

    @GetMapping
    public ResponseEntity<List<Duenio>> listar(){
        List<Duenio> duenio = service.getDuenios();

        if(duenio.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(duenio);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Duenio> buscarDuenio(@PathVariable Integer id){
        Optional<Duenio> duenio = service.getDuenio(id);

        if(duenio.isPresent())
            return ResponseEntity.ok(duenio.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Duenio> guardarDuenio(@RequestBody Duenio du){
        Duenio duenio = service.saveDuenio(du);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(duenio);
    }



    @PutMapping("/{id}")
    public ResponseEntity<Duenio> editar(@PathVariable Integer id,@RequestBody Duenio du){
        Optional<Duenio> existe = service.getDuenio(id);

        if (existe.isEmpty()){
            return ResponseEntity.notFound().build();}

        du.setId(id);
        Duenio actualizar = service.saveDuenio(du);
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

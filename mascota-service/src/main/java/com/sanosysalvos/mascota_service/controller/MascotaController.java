package com.sanosysalvos.mascota_service.controller;

import com.sanosysalvos.mascota_service.model.Mascota;
import com.sanosysalvos.mascota_service.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/mascotas")
public class MascotaController {
    @Autowired
    private MascotaService service;

    @GetMapping
    public ResponseEntity<List<Mascota>> Listar(){
        List<Mascota> mascota = service.getMascotas();
                if(mascota.isEmpty())
                    return ResponseEntity.noContent().build();
                else
                    return ResponseEntity.ok(mascota);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> buscarMascota(@PathVariable Integer id){
        Optional<Mascota> mascota = service.getMascota(id);
        if(mascota.isPresent())
            return ResponseEntity.ok(mascota.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Mascota> guardar(@RequestBody Mascota ma){
        Mascota mascota = service.saveMascota(ma);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mascota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mascota> editar(@PathVariable Integer id,@RequestBody Mascota ma){
        Optional<Mascota> existe = service.getMascota(id);

        if (existe.isEmpty()){
            return ResponseEntity.notFound().build();}

        ma.setId(id);
        Mascota actualizar = service.saveMascota(ma);
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

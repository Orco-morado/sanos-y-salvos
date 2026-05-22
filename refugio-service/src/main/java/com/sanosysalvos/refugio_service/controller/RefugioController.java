package com.sanosysalvos.refugio_service.controller;

import com.sanosysalvos.refugio_service.dto.RefugioComunaDTO;
import com.sanosysalvos.refugio_service.model.Refugio;
import com.sanosysalvos.refugio_service.service.RefugioService;
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
@RequestMapping("api/v1/refugios")
public class RefugioController {
    @Autowired
    private RefugioService service;

    //@GetMapping
    public ResponseEntity<List<Refugio>> Listar(){
        List<Refugio> refugio = service.getRefugios();
        if(refugio.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(refugio);
    }

    @GetMapping
    public ResponseEntity<List<Refugio>> ListarActivos(){
        List<Refugio> refugio = service.getRefugiosActivos();
        if(refugio.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(refugio);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Refugio> buscarRefugio(@PathVariable Integer id){
        Optional<Refugio> refugio = service.getRefugio(id);
        if(refugio.isPresent())
            return ResponseEntity.ok(refugio.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Refugio> guardar(@Valid @RequestBody Refugio re){
        Refugio refugio = service.saveRefugio(re);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(refugio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Refugio> editar(@PathVariable Integer id,@Valid @RequestBody Refugio re){
        Optional<Refugio> existe = service.getRefugio(id);

        if (existe.isEmpty()){
            return ResponseEntity.notFound().build();}

        re.setId(id);
        Refugio actualizar = service.saveRefugio(re);
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex){

        Map<String, String> errores = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errores) ;
    }

    @GetMapping("/comunas/{id}")
    public RefugioComunaDTO refugioConComuna(@PathVariable Integer id){
        return service.getRefugioComunaDTO(id);
    }

}

package com.sanosysalvos.reporte_desaparicion_service.controller;

import com.sanosysalvos.reporte_desaparicion_service.model.ReporteDesaparicion;
import com.sanosysalvos.reporte_desaparicion_service.service.ReporteDesaparicionService;
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
@RequestMapping("api/v1/reporte-desaparicion")
public class ReporteDesaparicionController {

    @Autowired
    private ReporteDesaparicionService service;

    // @GetMapping (Comentado, igual que en tu RefugioController)
    public ResponseEntity<List<ReporteDesaparicion>> listar(){
        List<ReporteDesaparicion> reportes = service.getReporte();
        if(reportes.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(reportes);
    }

    @GetMapping
    public ResponseEntity<List<ReporteDesaparicion>> getActivos(){
        List<ReporteDesaparicion> reportes = service.getReportesActivos();
        if(reportes.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(reportes);
    }

    @GetMapping("/{id}")
    public EntityModel<ReporteDesaparicion> getDesaparicion(@PathVariable Integer id){
        ReporteDesaparicion reporteDesaparicion = service.getReporte(id).orElseThrow();
        EntityModel<ReporteDesaparicion> model = EntityModel.of(reporteDesaparicion);

        model.add(
                linkTo(
                        methodOn(ReporteDesaparicionController.class).getDesaparicion(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(ReporteDesaparicionController.class).getActivos()
                ).withRel("Todas las Desapariciones")
        );

        return model;
    }
    /*public ResponseEntity<ReporteDesaparicion> buscarReporte(@PathVariable Integer id){
        Optional<ReporteDesaparicion> reporte = service.getReporte(id);
        if(reporte.isPresent())
            return ResponseEntity.ok(reporte.get());
        else
            return ResponseEntity.notFound().build();
    }*/

    @PostMapping
    public ResponseEntity<ReporteDesaparicion> guardar(@Valid @RequestBody ReporteDesaparicion re){
        ReporteDesaparicion reporte = service.saveReporte(re);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(reporte);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReporteDesaparicion> editar(@PathVariable Integer id, @Valid @RequestBody ReporteDesaparicion re){
        Optional<ReporteDesaparicion> existe = service.getReporte(id);

        // Si tu IDE te vuelve a dar el error de "Cannot resolve method isEmpty", cámbialo por: if (!existe.isPresent()) {
        if (existe.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        re.setId(id);
        ReporteDesaparicion actualizar = service.saveReporte(re);
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

}

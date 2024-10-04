package com.info.app.projectapp.controller.proyecto;

import com.info.app.projectapp.dto.errors.ErroresDto;
import com.info.app.projectapp.dto.project.ProyectoCreateDto;
import com.info.app.projectapp.dto.project.ProyectoCreatedDto;
import com.info.app.projectapp.dto.project.ProyectoDto;
import com.info.app.projectapp.dto.project.ProyectoUpdatedDto;
import com.info.app.projectapp.service.proyecto.ProyectoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class ProyectoController {

    private ProyectoService proyectoService;

    @PostMapping("/api/v1/proyecto")
    public ResponseEntity<?> createProject(@RequestBody ProyectoCreateDto proyectoCreateDto) {

        Optional<ProyectoCreatedDto> proyectoCreatedDto = proyectoService.createProject( proyectoCreateDto );

        return ResponseEntity
                .status( HttpStatus.CREATED )
                .body( proyectoCreatedDto.get() );
    }

    @PutMapping("/api/v1/proyecto/close/{idProyecto}")
    public ResponseEntity closeProject(@PathVariable("idProyecto") UUID idProyecto){
        Optional<ProyectoUpdatedDto> proyectoUpdatedDto = proyectoService.closeProject( idProyecto );

        if ( proyectoUpdatedDto.isEmpty() ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proyecto no encontrado");
        }

        return ResponseEntity.status( HttpStatus.NO_CONTENT ).build();
    }

    @GetMapping("/api/v1/proyecto")
    public List<ProyectoDto> getAllProyectos(
            @RequestParam(required = false, name = "fechaInicio")LocalDate fechaInicio,
            @RequestParam(required = false, name = "fechaFin") LocalDate fechaFin,
            @RequestParam(required = false, name = "nombre") String nombre
            ){

        System.out.println("Fecha de Inicio: " + fechaInicio);
        System.out.println("Fecha de Fin: " + fechaFin);
        System.out.println("Fecha de nombre: " + nombre);


        return proyectoService.getAllProyectos(
                Optional.ofNullable(fechaInicio),
                Optional.ofNullable(fechaFin) ,
                nombre
        );
    }

    @GetMapping("/api/v1/proyecto/{idProyecto}")
    public ResponseEntity<?> getProjectById(@PathVariable("idProyecto") UUID idProyecto){

        Optional<ProyectoDto> proyectoDto = proyectoService.getProyectoDtoById(idProyecto);

        if ( proyectoDto.isEmpty() ){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErroresDto(
                            String.format("El proyecto(id=%s) no existe", idProyecto.toString() ),
                            HttpStatus.NOT_FOUND.value(),
                            "/api/v1/proyecto/"+idProyecto.toString(
                    )));
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(proyectoDto.get());
    }

}

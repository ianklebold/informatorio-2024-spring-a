package com.info.app.projectapp.controller.proyecto;

import com.info.app.projectapp.domain.Proyecto;
import com.info.app.projectapp.dto.project.ProyectoCreateDto;
import com.info.app.projectapp.dto.project.ProyectoCreatedDto;
import com.info.app.projectapp.dto.project.ProyectoUpdatedDto;
import com.info.app.projectapp.dto.user.UsuarioDto;
import com.info.app.projectapp.service.proyecto.ProyectoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

}

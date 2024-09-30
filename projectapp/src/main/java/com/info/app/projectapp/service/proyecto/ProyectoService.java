package com.info.app.projectapp.service.proyecto;

import com.info.app.projectapp.domain.Proyecto;
import com.info.app.projectapp.dto.project.ProyectoCreateDto;
import com.info.app.projectapp.dto.project.ProyectoCreatedDto;
import com.info.app.projectapp.dto.project.ProyectoDto;
import com.info.app.projectapp.dto.project.ProyectoUpdatedDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProyectoService {

    Proyecto getProyectoById(UUID uuid);

    Optional<ProyectoDto> getProyectoDtoById(UUID uuid);

    Optional<ProyectoUpdatedDto> closeProject(UUID uuid);

    Optional<ProyectoCreatedDto> createProject(ProyectoCreateDto proyectoCreateDto);

    List<ProyectoDto> getAllProyectos(Optional<LocalDate> fechaInicio,
                                      Optional<LocalDate> fechaFin,
                                      String nombre);
}

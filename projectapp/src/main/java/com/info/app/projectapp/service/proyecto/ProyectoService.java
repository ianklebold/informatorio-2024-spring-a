package com.info.app.projectapp.service.proyecto;

import com.info.app.projectapp.domain.Proyecto;
import com.info.app.projectapp.dto.project.ProyectoCreateDto;
import com.info.app.projectapp.dto.project.ProyectoCreatedDto;
import com.info.app.projectapp.dto.project.ProyectoUpdatedDto;

import java.util.Optional;
import java.util.UUID;

public interface ProyectoService {

    Proyecto getProyectoById(UUID uuid);

    Optional<ProyectoUpdatedDto> closeProject(UUID uuid);

    Optional<ProyectoCreatedDto> createProject(ProyectoCreateDto proyectoCreateDto);

}

package com.info.app.projectapp.mappers.proyecto;

import com.info.app.projectapp.domain.Proyecto;
import com.info.app.projectapp.dto.project.ProyectoCreateDto;
import com.info.app.projectapp.dto.project.ProyectoCreatedDto;
import com.info.app.projectapp.dto.project.ProyectoUpdatedDto;

public interface ProjectMapper {

    ProyectoUpdatedDto projectToProyectoUpdatedDto(Proyecto proyecto);

    Proyecto proyectoCreateDtoToProyecto(ProyectoCreateDto proyectoCreateDto);

    ProyectoCreatedDto projectToProyectoCreatedDto(Proyecto proyecto);
}

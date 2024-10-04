package com.info.app.projectapp.mappers.task;

import com.info.app.projectapp.domain.Tarea;
import com.info.app.projectapp.dto.task.TaskCreatedDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TaskMapper {

    @Mapping(source = "proyecto.id", target = "uuidProyecto")
    TaskCreatedDto taskToTaskCreadDto(Tarea task);

    Tarea tareaToTaskCreateDto(TaskCreatedDto task);
}

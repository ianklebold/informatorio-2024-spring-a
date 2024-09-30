package com.info.app.projectapp.service.task;


import com.info.app.projectapp.domain.enums.EstadoTareaEnum;
import com.info.app.projectapp.dto.task.TaskCreatedDto;
import com.info.app.projectapp.dto.task.TaskDto;

import java.util.Optional;
import java.util.UUID;

public interface TaskService {

    Optional<TaskCreatedDto> createTask(TaskDto  task);

    boolean updateStateTask(UUID idTask, EstadoTareaEnum estadoTareaEnum);

}

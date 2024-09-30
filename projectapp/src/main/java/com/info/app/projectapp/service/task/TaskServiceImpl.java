package com.info.app.projectapp.service.task;

import com.info.app.projectapp.domain.enums.EstadoTareaEnum;
import com.info.app.projectapp.dto.task.TaskCreatedDto;
import com.info.app.projectapp.dto.task.TaskDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService{

    @Override
    public Optional<TaskCreatedDto> createTask(TaskDto task) {
        // Crear la tarea Task

            // Utilizar un mapper para convertir taskDto a Task

        //Si no existe Proyecto (Crear excepcion - Codigo de error 404)
        //Si existe, entonces buscarlo y asignarlo.

        // Si tiene documentos crearlos
        // Recordar el principio de SRP

        //Retornar el TaskCreatedDto
            // Utilizar un mapper para convertir Task TaskCreatedDto

        return null;
    }

    @Override
    public boolean updateStateTask(UUID idTask, EstadoTareaEnum estadoTareaEnum) {
        // Actualizar el endpoint closeProject
            // -> Si se cierra proyecto, tambien cierre todos las tareas (usar este servicio)
            // -> Guarde el proyecto

        // Buscar tarea por ID
            // --> Si no existe tarea error codigo 404.
            // --> Actualizar su estado a lo que indique estadoTareaEnum
            // --> Guardar
            // --> Retornar true en caso de que salio OK o False en otro caso.

        return false;
    }
}

package com.info.app.projectapp.controller.task;

import com.info.app.projectapp.service.task.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @DeleteMapping("/api/v1/tarea/{idTarea}")
    public ResponseEntity<?> deleteTarea(@PathVariable UUID idTarea){

        boolean isTaskDeleted = taskService.deleteTask( idTarea );

        if ( isTaskDeleted ){
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

}

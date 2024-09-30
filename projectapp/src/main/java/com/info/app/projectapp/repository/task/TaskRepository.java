package com.info.app.projectapp.repository.task;

import com.info.app.projectapp.domain.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Tarea, UUID> {
}

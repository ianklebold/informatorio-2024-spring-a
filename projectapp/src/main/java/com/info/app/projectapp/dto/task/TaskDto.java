package com.info.app.projectapp.dto.task;

import com.info.app.projectapp.dto.document.DocumentDto;

import java.util.List;
import java.util.UUID;

public record TaskDto(String titulo,
                      String descripcion,
                      UUID uuidProyecto,
                      List<DocumentDto> documents) {
}

package com.info.app.projectapp.dto.task;

import com.info.app.projectapp.domain.enums.EstadoTareaEnum;
import com.info.app.projectapp.dto.document.DocumentDto;

import java.util.List;
import java.util.UUID;

public record TaskCreatedDto(
        UUID id,
        String titulo,
        String descripcion,
        EstadoTareaEnum estado,
        UUID uuidProyecto,
        List<DocumentDto> documents
) {
}

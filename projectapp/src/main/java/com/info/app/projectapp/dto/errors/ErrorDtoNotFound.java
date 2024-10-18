package com.info.app.projectapp.dto.errors;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "Error no encontrado",
        description = "Esquema para indicar que existe un error de que no se encontro el recurso"
)
public record ErrorDtoNotFound(
        @Schema(description = "path del error", example = "\"/api/v1/proyecto\"")  String path,
        @Schema(description = "mensaje de error", example = "Error no se encontro el recurso") String mensaje) {
}

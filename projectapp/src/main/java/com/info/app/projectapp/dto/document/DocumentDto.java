package com.info.app.projectapp.dto.document;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "DTO Documento para crear"
)
public record DocumentDto(
        @Schema(description = "Nombre del documento", example = "Tarea por hacer") String nombre,
        @Schema(description = "Url al documento", example = "https://docs.google.com/document/d/15HvBJ3CkwAONXgsOJIIHAK98_rfkJDwR9gbWYAN6qfU/edit?tab=t.0#heading=h.hphmbv5qryry") String url) {
}

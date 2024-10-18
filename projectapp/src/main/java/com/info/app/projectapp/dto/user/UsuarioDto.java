package com.info.app.projectapp.dto.user;

import com.info.app.projectapp.domain.enums.RolEnum;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(
        name = "DTO Usuario para crear"
)
public record UsuarioDto(
        @Schema(description = "Nombre del usuario", example = "Pablo") String nombre,
        @Schema(description = "Email del usuario", example = "pablo@gmail.com") String email,
        @Schema(description = "Rol del usuario", example = "LIDER") RolEnum rol,
        @Schema(description = "id del proyecto") UUID idProyecto) {}

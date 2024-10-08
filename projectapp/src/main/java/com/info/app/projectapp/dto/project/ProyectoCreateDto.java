package com.info.app.projectapp.dto.project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public record ProyectoCreateDto(

        @NotNull(message = "El nombre del proyecto no puede ser nulo")
        @NotBlank(message = "El nombre del proyecto no puede ser vacio")
        @Size(max = 500, message = "El nombre del proyecto no puede ser mayor a 500 caracteres")
        String nombre,
        List<UUID> colaboradoresId,
        UUID liderId  ) {
}

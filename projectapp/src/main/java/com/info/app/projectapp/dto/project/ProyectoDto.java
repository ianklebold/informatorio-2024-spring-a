package com.info.app.projectapp.dto.project;

import com.info.app.projectapp.dto.user.UsuarioDto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record ProyectoDto(UUID id,
                          String nombre,
                          LocalDate fechaInicio,
                          LocalDate fechaFin,
                          UsuarioDto lider,
                          List<UsuarioDto> colaboradores) {
}

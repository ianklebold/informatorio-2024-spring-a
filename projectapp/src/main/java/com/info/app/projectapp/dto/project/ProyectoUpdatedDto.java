package com.info.app.projectapp.dto.project;

import com.info.app.projectapp.dto.user.UsuarioDto;

import java.time.LocalDate;

public record ProyectoUpdatedDto(String nombre, LocalDate fechaInicio, LocalDate fechaFin, UsuarioDto lider) {
}

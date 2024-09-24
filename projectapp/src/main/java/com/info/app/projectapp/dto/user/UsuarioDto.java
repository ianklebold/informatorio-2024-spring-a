package com.info.app.projectapp.dto.user;

import com.info.app.projectapp.domain.enums.RolEnum;

import java.util.UUID;

public record UsuarioDto(
        String nombre,
        String email,
        RolEnum rol,
        UUID idProyecto) {}

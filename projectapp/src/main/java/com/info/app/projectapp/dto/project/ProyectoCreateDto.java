package com.info.app.projectapp.dto.project;

import java.util.List;
import java.util.UUID;

public record ProyectoCreateDto( String nombre, List<UUID> colaboradoresId, UUID liderId  ) {
}

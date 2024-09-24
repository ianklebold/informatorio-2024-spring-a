package com.info.app.projectapp.service.proyecto;

import com.info.app.projectapp.domain.Proyecto;

import java.util.UUID;

public interface ProyectoService {

    Proyecto getProyectoById(UUID uuid);

}

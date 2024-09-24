package com.info.app.projectapp.service.proyecto;

import com.info.app.projectapp.domain.Proyecto;
import com.info.app.projectapp.repository.proyecto.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProyectoServiceImpl implements ProyectoService{

    private ProyectoRepository proyectoRepository;

    @Override
    public Proyecto getProyectoById(UUID uuid) {
        Optional<Proyecto> optionalProyecto = proyectoRepository.findById(uuid);

        if (optionalProyecto.isPresent()) {
            return optionalProyecto.get();
        }else {
            throw new NoSuchElementException("Proyecto no encontrado");
        }
    }


}

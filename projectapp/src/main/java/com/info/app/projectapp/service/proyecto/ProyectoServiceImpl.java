package com.info.app.projectapp.service.proyecto;

import com.info.app.projectapp.domain.Proyecto;
import com.info.app.projectapp.dto.project.ProyectoCreateDto;
import com.info.app.projectapp.dto.project.ProyectoCreatedDto;
import com.info.app.projectapp.dto.project.ProyectoUpdatedDto;
import com.info.app.projectapp.mappers.proyecto.ProjectMapper;
import com.info.app.projectapp.repository.proyecto.ProyectoRepository;
import com.info.app.projectapp.repository.usuario.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProyectoServiceImpl implements ProyectoService{

    private final UsuarioRepository usuarioRepository;
    private ProyectoRepository proyectoRepository;

    private ProjectMapper projectMapper;

    @Override
    public Proyecto getProyectoById(UUID uuid) {
        Optional<Proyecto> optionalProyecto = proyectoRepository.findById(uuid);

        if (optionalProyecto.isPresent()) {
            return optionalProyecto.get();
        }else {
            throw new NoSuchElementException("Proyecto no encontrado");
        }
    }

    @Override
    public Optional<ProyectoUpdatedDto> closeProject(UUID uuid) {
        Optional<Proyecto> proyecto = proyectoRepository.findById(uuid);

        if ( proyecto.isPresent() ){
            var proyectoEncontrado = proyecto.get();
            proyectoEncontrado.setFechaFin( LocalDate.now() );
            var proyectoUpdated = proyectoRepository.save( proyectoEncontrado );
            return Optional.of( projectMapper.projectToProyectoUpdatedDto( proyectoUpdated )  );
        }

        return Optional.empty();
    }

    @Override
    public Optional<ProyectoCreatedDto> createProject(ProyectoCreateDto proyectoCreateDto) {

        Proyecto newProject = projectMapper.proyectoCreateDtoToProyecto( proyectoCreateDto );

        if ( !proyectoCreateDto.colaboradoresId().isEmpty() ){

            //Controlar que todos los usuarios existan en la bd


            //Controlar que el usuario no tenga un proyecto ya asignado

        }

        if ( proyectoCreateDto.liderId() != null ){

            //Controlar que el usuario exista en la bd

            //Controlar que el usuario no sea lider en otro proyecto.

        }

        return Optional.of(
                projectMapper.projectToProyectoCreatedDto( proyectoRepository.save( newProject ) )
        );
    }
}

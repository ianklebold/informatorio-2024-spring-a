package com.info.app.projectapp.mappers.proyecto;

import com.info.app.projectapp.domain.Proyecto;
import com.info.app.projectapp.dto.project.ProyectoCreateDto;
import com.info.app.projectapp.dto.project.ProyectoCreatedDto;
import com.info.app.projectapp.dto.project.ProyectoDto;
import com.info.app.projectapp.dto.project.ProyectoUpdatedDto;
import com.info.app.projectapp.mappers.user.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
@AllArgsConstructor
public class ProjectMapperImpl implements  ProjectMapper{

    private UserMapper userMapper;

    @Override
    public ProyectoUpdatedDto projectToProyectoUpdatedDto(Proyecto proyecto) {

        return new ProyectoUpdatedDto(
                proyecto.getNombre(),
                proyecto.getFechaInicio(),
                proyecto.getFechaFin(),
                userMapper.usuarioToUsuarioDto(proyecto.getLider())
        );
    }

    @Override
    public Proyecto proyectoCreateDtoToProyecto(ProyectoCreateDto proyectoCreateDto) {

        Proyecto proyecto = new Proyecto();
        proyecto.setId( UUID.randomUUID() );
        proyecto.setFechaInicio( LocalDate.now() );
        proyecto.setNombre( proyectoCreateDto.nombre() );

        return proyecto;
    }

    @Override
    public ProyectoCreatedDto projectToProyectoCreatedDto(Proyecto proyecto) {

        return new ProyectoCreatedDto(
                proyecto.getId(),
                proyecto.getNombre(),
                proyecto.getFechaInicio(),
                userMapper.usuarioToUsuarioDto( proyecto.getLider() ),
                proyecto.getColaboradores()
                        .stream()
                        .map( colaborador -> userMapper.usuarioToUsuarioDto( colaborador ) )
                        .toList()
        );
    }

    @Override
    public ProyectoDto proyectoToProyectoDto(Proyecto proyecto) {

        return new ProyectoDto(
                proyecto.getId(),
                proyecto.getNombre(),
                proyecto.getFechaInicio(),
                proyecto.getFechaFin(),
                userMapper.usuarioToUsuarioDto( proyecto.getLider() ),
                proyecto.getColaboradores()
                        .stream()
                        .map( colaborador -> userMapper.usuarioToUsuarioDto( colaborador ) )
                        .toList()
        );
    }
}

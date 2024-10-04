package com.info.app.projectapp.service.user;

import com.info.app.projectapp.domain.Proyecto;
import com.info.app.projectapp.domain.Usuario;
import com.info.app.projectapp.domain.enums.RolEnum;
import com.info.app.projectapp.dto.user.UsuarioDto;
import com.info.app.projectapp.mappers.user.UserMapper;
import com.info.app.projectapp.repository.proyecto.ProyectoRepository;
import com.info.app.projectapp.repository.usuario.UsuarioRepository;
import com.info.app.projectapp.service.proyecto.ProyectoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserMapper userMapper;

    private ProyectoService proyectoService;

    private ProyectoRepository proyectoRepository;

    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDto createUser(UsuarioDto usuario) {

        Usuario usuarioCreated = userMapper.usuarioDtoToUsuario(usuario);

        Proyecto proyecto = proyectoService.getProyectoById( usuario.idProyecto() );

        usuarioCreated.setProyecto( proyecto );
        //proyecto.setUsuarioByRol( usuarioCreated ); <-- TODO No lo necesitamos por el Cascade de Proyecto a Usuario. Eliminarlo!

        //proyectoRepository.save( proyecto ); <-- TODO No lo necesitamos por el Cascade de Proyecto a Usuario. Eliminarlo!
        return userMapper.usuarioToUsuarioDto( usuarioRepository.save( usuarioCreated ) );
    }

    @Override
    public boolean checkIfUserExist(UUID id) {
        if (!usuarioRepository.existsById(id)) {
            throw new NoSuchElementException("El colaborador con ID "+id+" no existe." );
        }
        return true;
    }
}

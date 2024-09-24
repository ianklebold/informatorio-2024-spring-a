package com.info.app.projectapp.mappers.user;

import com.info.app.projectapp.domain.Usuario;
import com.info.app.projectapp.dto.user.UsuarioDto;

public interface UserMapper {

    Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);

    UsuarioDto usuarioToUsuarioDto(Usuario usuario);

}

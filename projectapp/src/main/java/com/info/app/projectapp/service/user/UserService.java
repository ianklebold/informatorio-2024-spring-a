package com.info.app.projectapp.service.user;

import com.info.app.projectapp.dto.user.UsuarioDto;

import java.util.UUID;

public interface UserService {
    UsuarioDto createUser(UsuarioDto usuario);

    boolean checkIfUserExist(UUID id);


}

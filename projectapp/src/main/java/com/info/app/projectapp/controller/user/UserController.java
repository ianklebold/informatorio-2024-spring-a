package com.info.app.projectapp.controller.user;

import com.info.app.projectapp.dto.user.UsuarioDto;
import com.info.app.projectapp.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody UsuarioDto usuario){
        UsuarioDto usuarioDto = userService.createUser(usuario);

        return ResponseEntity
                .status( HttpStatus.CREATED )
                .body( usuarioDto );
    }

}

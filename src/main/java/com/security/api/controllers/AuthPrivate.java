package com.security.api.controllers;

import com.security.api.models.UsuarioDto;
import com.security.api.services.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth/private")
public class AuthPrivate {

    @Autowired
    private ServicioUsuario servicioUsuario;

    @PostMapping("/create")
    public ResponseEntity<?> crate(@RequestBody UsuarioDto usuarioDto){
        try{
            servicioUsuario.create(usuarioDto.getName(), usuarioDto.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body("Todo cool");
        }
        catch (Exception ex){
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", "Tu maldita consulta arruino el programa");
            error.put("error", ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
}

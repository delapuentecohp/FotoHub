package com.ForoHub.ForoHub.controller;

import com.ForoHub.ForoHub.domain.usuario.Usuario;
import com.ForoHub.ForoHub.domain.usuario.dto.AutenticacionUsuarioDTO;
import com.ForoHub.ForoHub.infra.security.dto.JWTtokenDTO;
import com.ForoHub.ForoHub.infra.service.TokenService;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Tag(name= "Autenticacion", description = "Obtiene el token del usaurio designado para el acceso")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<JWTtokenDTO> autenticarUsuario(@RequestBody @Valid AutenticacionUsuarioDTO autenticacionUsuario){
        Authentication authToken = new UsernamePasswordAuthenticationToken(autenticacionUsuario.username(),autenticacionUsuario.password());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());

        return ResponseEntity.ok(new JWTtokenDTO(JWTtoken));
    }
}

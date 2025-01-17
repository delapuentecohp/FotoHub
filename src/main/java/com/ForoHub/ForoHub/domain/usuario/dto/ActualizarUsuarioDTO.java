package com.ForoHub.ForoHub.domain.usuario.dto;

import com.ForoHub.ForoHub.domain.usuario.Role;

public record ActualizarUsuarioDTO(
        String password,
        Role role,
        String nombre,
        String apellido,
        String email,
        Boolean enabled
) {
}

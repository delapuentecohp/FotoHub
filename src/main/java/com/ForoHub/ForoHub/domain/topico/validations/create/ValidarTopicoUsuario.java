package com.ForoHub.ForoHub.domain.topico.validations.create;

import com.ForoHub.ForoHub.domain.topico.dto.CrearTopicoDTO;
import com.ForoHub.ForoHub.domain.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.validation.ValidationException;

@Component
public class ValidarTopicoUsuario implements ValidarTopicoCreado{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validate (CrearTopicoDTO data){
        var existeUsuario = repository.existsById(data.usuarioId());
        if(!existeUsuario){
            throw new ValidationException("Este usuario no existe");
        }

        var usuarioHabilitado = repository.findById(data.usuarioId()).get().getEnabled();
        if(!usuarioHabilitado){
            throw new ValidationException("Este usuario fue deshabilitado");
        }
    }

}

package com.ForoHub.ForoHub.domain.respuesta.validations.create;

import com.ForoHub.ForoHub.domain.respuesta.dto.CrearRespuestaDTO;
import com.ForoHub.ForoHub.domain.usuario.repository.UsuarioRepository;
import jakarta.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespuestaUsuarioValida implements ValidarRespuestaCreada{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validate(CrearRespuestaDTO data) throws ValidationException {
        var usuarioExiste = repository.existsById(data.usuarioId());
        if(!usuarioExiste){
            throw new ValidationException("Este usuario no existe");
        }

        var usuarioHabilitado = repository.findById(data.usuarioId()).get().isEnabled();
        if(!usuarioHabilitado){
            throw new ValidationException("este usuario no esta habilitado");
        }
    }
}

package com.ForoHub.ForoHub.domain.respuesta.validations.create;

import com.ForoHub.ForoHub.domain.respuesta.dto.CrearRespuestaDTO;
import com.ForoHub.ForoHub.domain.topico.Estado;
import com.ForoHub.ForoHub.domain.topico.repository.TopicoRepository;
import jakarta.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespuestaTopicoValida implements ValidarRespuestaCreada{

    @Autowired
    private TopicoRepository repository;

    @Override
    public void validate(CrearRespuestaDTO data) throws ValidationException {
        var topicoExiste = repository.existsById(data.topicoId());

        if(!topicoExiste){
            throw new ValidationException("Este topico existe");
        }

        var topicoAbierto = repository.findById(data.topicoId()).get().getEstado();
        if(topicoAbierto != Estado.OPEN){
            throw new ValidationException("Este topico no esta abierto");
        }
    }
}

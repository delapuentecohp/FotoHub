package com.ForoHub.ForoHub.domain.respuesta.validations.update;

import com.ForoHub.ForoHub.domain.respuesta.Respuesta;
import com.ForoHub.ForoHub.domain.respuesta.dto.ActualizarRespuestaDTO;
import com.ForoHub.ForoHub.domain.respuesta.repository.RespuestaRepository;
import com.ForoHub.ForoHub.domain.topico.repository.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ForoHub.ForoHub.domain.topico.Estado;

@Component
public class SolucionDuplicada implements ValidarRespuestaActualizada{

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validate (ActualizarRespuestaDTO data, Long respuestaId) {
        if(data.solucion()){
            Respuesta respuesta = respuestaRepository.getReferenceById(respuestaId);
            var topicoResuelto = topicoRepository.getReferenceById(respuesta.getTopico().getId());
            if (topicoResuelto.getEstado() == Estado.CLOSED){
                throw new ValidationException("Este topico ya esta solucionado");
            }
        }
    }
}

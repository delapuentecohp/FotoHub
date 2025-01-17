package com.ForoHub.ForoHub.domain.respuesta.validations.create;

import com.ForoHub.ForoHub.domain.respuesta.dto.CrearRespuestaDTO;
import jakarta.xml.bind.ValidationException;

public interface ValidarRespuestaCreada {
    void validate(CrearRespuestaDTO data) throws ValidationException;
}

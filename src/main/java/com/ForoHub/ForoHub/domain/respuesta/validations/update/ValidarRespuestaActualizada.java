package com.ForoHub.ForoHub.domain.respuesta.validations.update;

import com.ForoHub.ForoHub.domain.respuesta.dto.ActualizarRespuestaDTO;

public interface ValidarRespuestaActualizada {
    void validate(ActualizarRespuestaDTO data, Long respuestaId);
}

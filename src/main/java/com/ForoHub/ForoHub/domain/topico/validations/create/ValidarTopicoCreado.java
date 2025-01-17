package com.ForoHub.ForoHub.domain.topico.validations.create;

import com.ForoHub.ForoHub.domain.topico.dto.CrearTopicoDTO;
import jakarta.xml.bind.ValidationException;

public interface ValidarTopicoCreado {
    void validate(CrearTopicoDTO data);
}

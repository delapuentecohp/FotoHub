package com.ForoHub.ForoHub.domain.topico.dto;

import com.ForoHub.ForoHub.domain.topico.Estado;

public record ActualizarTopicoDTO(
        String titulo,
        String mensaje,
        Estado estado,
        Long cursoId
) {
}

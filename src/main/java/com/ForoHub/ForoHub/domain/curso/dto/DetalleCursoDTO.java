package com.ForoHub.ForoHub.domain.curso.dto;

import com.ForoHub.ForoHub.domain.curso.Categoria;
import com.ForoHub.ForoHub.domain.curso.Curso;

public record DetalleCursoDTO(
        Long id,
        String name,
        Categoria categoria,
        Boolean activo) {

    public DetalleCursoDTO(Curso curso){
        this(
                curso.getId(),
                curso.getName(),
                curso.getCategoria(),
                curso.getActivo()
        );
    }
}

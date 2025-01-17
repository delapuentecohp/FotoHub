package com.ForoHub.ForoHub.domain.curso.dto;

import com.ForoHub.ForoHub.domain.curso.Categoria;

public record ActualizarCursoDTO (
        String name,
        Categoria categoria,
        Boolean activo
){
}

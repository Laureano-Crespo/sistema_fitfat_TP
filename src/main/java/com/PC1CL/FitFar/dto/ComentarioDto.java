package com.PC1CL.FitFar.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ComentarioDto {

    private Integer idComentario;
    private String comentario;
    private RecetaDto receta;
}

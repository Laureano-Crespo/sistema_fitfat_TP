package com.PC1CL.FitFar.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ValoracionDto {

    private Integer valoracion;
    private RecetaDto receta;
    private UsuarioDto usuario;
}

package com.PC1CL.FitFar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioDto {

    private Integer idUsuario;
    private String nombre;
    private String correo;
}

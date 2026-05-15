package com.PC1CL.FitFar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RecetaDto {

    private Integer idReceta;
    private String titulo;
    private List<Integer> ingredientes;
}
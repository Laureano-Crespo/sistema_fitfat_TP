package com.PC1CL.FitFar.Service;

import com.PC1CL.FitFar.Entity.Instrucciones;
import com.PC1CL.FitFar.Entity.Receta;
import com.PC1CL.FitFar.Entity.RecetaHasIngredientes;
import com.PC1CL.FitFar.dto.InstruccionesDto;
import com.PC1CL.FitFar.dto.RecetaDto;
import com.PC1CL.FitFar.dto.RecetaHasIngredienteDto;

import java.util.List;

public interface RecetaService {

    ///Recetas
    List<Receta> listarRecetas();

    Receta obtenerRecetaPorId(Integer id);

    Receta registrarReceta(Receta receta);

    Receta actualizarReceta(Integer id, Receta receta);

    void eliminarReceta(Integer id);

    ///Ingrediente en receta
    RecetaHasIngredientes agregarIngredienteAReceta(Integer idReceta, RecetaHasIngredienteDto request);

    RecetaDto obtenerRecetarioPorId(Integer idReceta);

    ///Categoria
    List<Receta> listarPorCategoria(Integer idCategoria);

    List<Receta> listarPorPais(Integer idPais);

    List<InstruccionesDto> listarInstruccionesPorReceta(Integer idReceta);

    Instrucciones agregarInstruccion(Integer idReceta, Instrucciones instruccion);

}

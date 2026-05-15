package com.PC1CL.FitFar.Service;

import com.PC1CL.FitFar.Entity.Comentario;
import com.PC1CL.FitFar.Entity.Favorito;
import com.PC1CL.FitFar.Entity.Valoracion;
import com.PC1CL.FitFar.dto.ComentarioDto;
import com.PC1CL.FitFar.dto.FavoritoDto;
import com.PC1CL.FitFar.dto.ValoracionDto;

import java.util.List;

public interface InteraccionService {

    Comentario comentarReceta(Integer idUsuario, Integer idReceta, Comentario comentario);

    List<ComentarioDto> listarComentariosPorReceta(Integer idReceta);

    Valoracion valorarReceta(Integer idUsuario, Integer idReceta, Valoracion valoracion);

    List<ValoracionDto> listaDeValoracionPorReceta(Integer idReceta);

    Favorito agregarFavorito(Integer idUsuario, Integer idReceta);

    void eliminarFavorito(Integer idUsuario, Integer idReceta);

    List<FavoritoDto> listarFavoritosPorUsuario(Integer idUsuario);
}

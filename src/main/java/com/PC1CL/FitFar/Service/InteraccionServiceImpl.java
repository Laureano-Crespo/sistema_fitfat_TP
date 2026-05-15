package com.PC1CL.FitFar.Service;

import com.PC1CL.FitFar.Entity.*;
import com.PC1CL.FitFar.Repository.*;
import com.PC1CL.FitFar.dto.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InteraccionServiceImpl implements InteraccionService {

    private final UsuarioRepository usuarioRepository;
    private final RecetaRepository recetaRepository;
    private final ComentarioRepository comentarioRepository;
    private final ValoracionRepository valoracionRepository;
    private final FavoritoRepository favoritoRepository;

    @Override
    public Comentario comentarReceta(Integer idUsuario, Integer idReceta, Comentario comentario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Receta receta = recetaRepository.findById(idReceta)
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));

        comentario.setUsuario(usuario);
        comentario.setReceta(receta);
        comentario.setFechaRegistro(LocalDateTime.now());

        return comentarioRepository.save(comentario);
    }

    @Override
    public List<ComentarioDto> listarComentariosPorReceta(Integer idReceta) {

        Receta receta = recetaRepository.findById(idReceta)
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));

        List<Comentario> comentarios = comentarioRepository.findByReceta(receta);

        return comentarios.stream()
                .map(comentario -> new ComentarioDto(
                        comentario.getIdComentario(),
                        comentario.getComentario(),
                        new RecetaDto(
                                comentario.getReceta().getIdReceta(),
                                comentario.getReceta().getTitulo()
                        )
                ))
                .toList();
    }

    @Override
    public Valoracion valorarReceta(Integer idUsuario, Integer idReceta, Valoracion valoracion) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Receta receta = recetaRepository.findById(idReceta)
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));

        ValoracionPK valoracionPK = new ValoracionPK();
        valoracionPK.setIdUsuario(idUsuario);
        valoracionPK.setIdReceta(idReceta);

        valoracion.setValoracionPK(valoracionPK);
        valoracion.setUsuario(usuario);
        valoracion.setReceta(receta);

        return valoracionRepository.save(valoracion);
    }

    @Override
    public List<ValoracionDto> listaDeValoracionPorReceta(Integer idReceta) {

        Receta receta = recetaRepository.findById(idReceta)
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));

        List<Valoracion> valoraciones = valoracionRepository.findByReceta(receta);

        return valoraciones.stream()
                .map(valoracion -> new ValoracionDto(
                        valoracion.getPuntuacion(),
                        new RecetaDto(
                                valoracion.getReceta().getIdReceta(),
                                valoracion.getReceta().getTitulo()
                        ),
                        new UsuarioDto(
                                valoracion.getUsuario().getIdUsuario(),
                                valoracion.getUsuario().getNombre(),
                                valoracion.getUsuario().getEmail()
                        )
                ))
                .toList();
    }

    @Override
    public Favorito agregarFavorito(Integer idUsuario, Integer idReceta) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Receta receta = recetaRepository.findById(idReceta)
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));

        FavoritoPK favoritoPK = new FavoritoPK();
        favoritoPK.setIdUsuario(idUsuario);
        favoritoPK.setIdReceta(idReceta);

        Favorito favorito = new Favorito();
        favorito.setFavoritosPK(favoritoPK);
        favorito.setUsuario(usuario);
        favorito.setReceta(receta);

        return favoritoRepository.save(favorito);
    }

    @Override
    @Transactional
    public void eliminarFavorito(Integer idUsuario, Integer idReceta) {
        favoritoRepository.deleteByFavoritosPK_IdUsuarioAndFavoritosPK_IdReceta(idUsuario, idReceta);
    }

    @Override
    public List<FavoritoDto> listarFavoritosPorUsuario(Integer idUsuario) {

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        List<Favorito> favoritos = favoritoRepository.findByUsuario(usuario);

        return favoritos.stream()
                .map(favorito -> new FavoritoDto(
                        favorito.getFavoritosPK(),
                        new RecetaDto(
                                favorito.getReceta().getIdReceta(),
                                favorito.getReceta().getTitulo()
                        ),
                        new UsuarioDto(
                                favorito.getUsuario().getIdUsuario(),
                                favorito.getUsuario().getNombre(),
                                favorito.getUsuario().getEmail()
                        )
                ))
                .toList();
    }
}

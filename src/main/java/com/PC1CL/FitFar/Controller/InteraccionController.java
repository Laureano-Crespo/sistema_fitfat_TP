package com.PC1CL.FitFar.Controller;

import com.PC1CL.FitFar.Entity.Comentario;
import com.PC1CL.FitFar.Entity.Favorito;
import com.PC1CL.FitFar.Entity.Valoracion;
import com.PC1CL.FitFar.Service.InteraccionService;
import com.PC1CL.FitFar.dto.ComentarioDto;
import com.PC1CL.FitFar.dto.FavoritoDto;
import com.PC1CL.FitFar.dto.ValoracionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interacciones")
@RequiredArgsConstructor
public class InteraccionController {

    private final InteraccionService interaccionService;

    @PostMapping("/usuarios/{idUsuario}/recetas/{idReceta}/comentarios")
    public Comentario comentarReceta(@PathVariable Integer idUsuario,
                                     @PathVariable Integer idReceta,
                                     @RequestBody Comentario comentario) {
        return interaccionService.comentarReceta(idUsuario, idReceta, comentario);
    }

    @GetMapping("/recetas/{idReceta}/comentarios")
    public List<ComentarioDto> listarComentariosPorReceta(@PathVariable Integer idReceta) {
        return interaccionService.listarComentariosPorReceta(idReceta);
    }

    @PostMapping("/usuarios/{idUsuario}/recetas/{idReceta}/valoraciones")
    public Valoracion valorarReceta(@PathVariable Integer idUsuario,
                                       @PathVariable Integer idReceta,
                                       @RequestBody Valoracion valoracion) {
        return interaccionService.valorarReceta(idUsuario, idReceta, valoracion);
    }

    @GetMapping("/recetas/{idReceta}/valoraciones")
    public List<ValoracionDto> listaDeValoracionPorReceta(@PathVariable Integer idReceta) {
        return interaccionService.listaDeValoracionPorReceta(idReceta);
    }

    @PostMapping("/usuarios/{idUsuario}/recetas/{idReceta}/favoritos")
    public Favorito agregarFavorito(@PathVariable Integer idUsuario,
                                    @PathVariable Integer idReceta) {
        return interaccionService.agregarFavorito(idUsuario, idReceta);
    }

    @DeleteMapping("/usuarios/{idUsuario}/recetas/{idReceta}/favoritos")
    public void eliminarFavorito(@PathVariable Integer idUsuario,
                                 @PathVariable Integer idReceta) {
        interaccionService.eliminarFavorito(idUsuario, idReceta);
    }

    @GetMapping("/usuarios/{idUsuario}/favoritos")
    public List<FavoritoDto> listarFavoritosPorUsuario(@PathVariable Integer idUsuario) {
        return interaccionService.listarFavoritosPorUsuario(idUsuario);
    }
}
package com.PC1CL.FitFar.Repository;

import com.PC1CL.FitFar.Entity.Favorito;
import com.PC1CL.FitFar.Entity.FavoritoPK;
import com.PC1CL.FitFar.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoritoRepository extends JpaRepository<Favorito, FavoritoPK> {

    List<Favorito> findByUsuario(Usuario usuario);

    void deleteByFavoritosPK_IdUsuarioAndFavoritosPK_IdReceta(Integer idUsuario, Integer idReceta);
}
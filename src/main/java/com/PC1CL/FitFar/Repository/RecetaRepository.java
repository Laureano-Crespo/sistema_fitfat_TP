package com.PC1CL.FitFar.Repository;

import com.PC1CL.FitFar.Entity.Categoria;
import com.PC1CL.FitFar.Entity.Pais;
import com.PC1CL.FitFar.Entity.Receta;
import com.PC1CL.FitFar.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecetaRepository extends JpaRepository<Receta, Integer> {

    List<Receta> findByCategoria(Categoria categoria);

    List<Receta> findByPais(Pais pais);

}

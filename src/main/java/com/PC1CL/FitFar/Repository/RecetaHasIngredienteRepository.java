package com.PC1CL.FitFar.Repository;

import com.PC1CL.FitFar.Entity.Receta;
import com.PC1CL.FitFar.Entity.RecetaHasIngredientePK;
import com.PC1CL.FitFar.Entity.RecetaHasIngredientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecetaHasIngredienteRepository extends JpaRepository<RecetaHasIngredientes, RecetaHasIngredientePK> {

    List<RecetaHasIngredientes> findByReceta(Receta receta);
}

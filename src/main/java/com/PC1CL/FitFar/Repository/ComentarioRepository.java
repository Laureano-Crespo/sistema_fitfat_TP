package com.PC1CL.FitFar.Repository;

import com.PC1CL.FitFar.Entity.Comentario;
import com.PC1CL.FitFar.Entity.Receta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

    List<Comentario> findByReceta(Receta receta);

}

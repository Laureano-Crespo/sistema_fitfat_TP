package com.PC1CL.FitFar.Repository;

import com.PC1CL.FitFar.Entity.Receta;
import com.PC1CL.FitFar.Entity.Valoracion;
import com.PC1CL.FitFar.Entity.ValoracionPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValoracionRepository extends JpaRepository<Valoracion, ValoracionPK> {

    List<Valoracion> findByReceta(Receta receta);
}
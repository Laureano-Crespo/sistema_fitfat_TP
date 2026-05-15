package com.PC1CL.FitFar.Repository;

import com.PC1CL.FitFar.Entity.Instrucciones;
import com.PC1CL.FitFar.Entity.Receta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstruccionesRepository extends JpaRepository<Instrucciones, Integer> {

    List<Instrucciones> findByReceta(Receta receta);

}

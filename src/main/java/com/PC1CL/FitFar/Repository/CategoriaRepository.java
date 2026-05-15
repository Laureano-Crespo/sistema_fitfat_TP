package com.PC1CL.FitFar.Repository;

import com.PC1CL.FitFar.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import com.PC1CL.FitFar.Entity.Usuario;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}

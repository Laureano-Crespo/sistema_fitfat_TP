package com.PC1CL.FitFar.Service;

import com.PC1CL.FitFar.Entity.Categoria;
import com.PC1CL.FitFar.Entity.Ingrediente;
import com.PC1CL.FitFar.Entity.Pais;

import java.util.List;

public interface CatalogoService {

    List<Categoria> listarCategorias();

    Categoria registrarCategoria(Categoria categoria);

    void eliminarCategoria(Integer idCategoria);

    List<Pais> listarPaises();

    Pais registrarPais(Pais pais);

    void eliminarPais(Integer idPais);

    List<Ingrediente> listarIngredientes();

    Ingrediente registrarIngrediente(Ingrediente ingrediente);

    void eliminarIngrediente(Integer idIngrediente);

}

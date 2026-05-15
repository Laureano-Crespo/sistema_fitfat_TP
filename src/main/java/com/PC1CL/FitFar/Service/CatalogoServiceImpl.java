package com.PC1CL.FitFar.Service;

import com.PC1CL.FitFar.Entity.Categoria;
import com.PC1CL.FitFar.Entity.Ingrediente;
import com.PC1CL.FitFar.Entity.Pais;
import com.PC1CL.FitFar.Entity.Usuario;
import com.PC1CL.FitFar.Repository.CategoriaRepository;
import com.PC1CL.FitFar.Repository.IngredienteRepository;
import com.PC1CL.FitFar.Repository.PaisRepository;
import com.PC1CL.FitFar.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogoServiceImpl implements CatalogoService {

    private final CategoriaRepository categoriaRepository;
    private final PaisRepository paisRepository;
    private final IngredienteRepository ingredienteRepository;

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria registrarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void eliminarCategoria(Integer idCategoria) {

        Categoria categoria = categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        categoriaRepository.delete(categoria);
    }

    @Override
    public List<Pais> listarPaises() {
        return paisRepository.findAll();
    }

    @Override
    public Pais registrarPais(Pais pais) {
        return paisRepository.save(pais);
    }

    @Override
    public void eliminarPais(Integer idPais) {

        Pais Pais = paisRepository.findById(idPais)
                .orElseThrow(() -> new RuntimeException("Pais no encontrado"));

        paisRepository.delete(Pais);
    }

    @Override
    public List<Ingrediente> listarIngredientes() {
        return ingredienteRepository.findAll();
    }

    @Override
    public Ingrediente registrarIngrediente(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    @Override
    public void eliminarIngrediente(Integer idIngrediente) {

        Ingrediente ingrediente = ingredienteRepository.findById(idIngrediente)
                .orElseThrow(() -> new RuntimeException("Ingrediente no encontrado"));

        ingredienteRepository.delete(ingrediente);
    }
}

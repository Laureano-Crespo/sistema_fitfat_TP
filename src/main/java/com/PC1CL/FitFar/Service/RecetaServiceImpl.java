package com.PC1CL.FitFar.Service;

import com.PC1CL.FitFar.Entity.*;
import com.PC1CL.FitFar.Repository.*;
import com.PC1CL.FitFar.dto.InstruccionesDto;
import com.PC1CL.FitFar.dto.RecetaDto;
import com.PC1CL.FitFar.dto.RecetaHasIngredienteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecetaServiceImpl implements RecetaService {

    private final RecetaRepository recetaRepository;
    private final CategoriaRepository categoriaRepository;
    private final PaisRepository paisRepository;
    private final InstruccionesRepository instruccionesRepository;
    private final IngredienteRepository ingredienteRepository;
    private final RecetaHasIngredienteRepository recetaHasIngredienteRepository;

    ///Recetas
    @Override
    public List<Receta> listarRecetas() {
        return recetaRepository.findAll();
    }

    @Override
    public Receta obtenerRecetaPorId(Integer id) {
        return recetaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));
    }

    @Override
    public Receta registrarReceta(Receta receta) {
        return recetaRepository.save(receta);
    }

    @Override
    public Receta actualizarReceta(Integer id, Receta receta) {
        Receta recetaExistente = obtenerRecetaPorId(id);

        recetaExistente.setTitulo(receta.getTitulo());
        recetaExistente.setDescripcion(receta.getDescripcion());
        recetaExistente.setTiempoPreparacion(receta.getTiempoPreparacion());
        recetaExistente.setDificultad(receta.getDificultad());
        recetaExistente.setPorciones(receta.getPorciones());
        recetaExistente.setEstado(receta.getEstado());
        recetaExistente.setCategoria(receta.getCategoria());
        recetaExistente.setPais(receta.getPais());

        return recetaRepository.save(recetaExistente);
    }

    @Override
    public void eliminarReceta(Integer id) {
        Receta receta = obtenerRecetaPorId(id);
        recetaRepository.delete(receta);
    }

    ///Categoria

    @Override
    public List<Receta> listarPorCategoria(Integer idCategoria) {
        Categoria categoria = categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        return recetaRepository.findByCategoria(categoria);
    }

    @Override
    public List<Receta> listarPorPais(Integer idPais) {
        Pais pais = paisRepository.findById(idPais)
                .orElseThrow(() -> new RuntimeException("País no encontrado"));

        return recetaRepository.findByPais(pais);
    }

    @Override
    public List<InstruccionesDto> listarInstruccionesPorReceta(Integer idReceta) {

        Receta receta = obtenerRecetaPorId(idReceta);

        List<Instrucciones> instrucciones = instruccionesRepository.findByReceta(receta);

        return instrucciones.stream()
                .map(instruccion -> new InstruccionesDto(
                        instruccion.getNumeroPaso(),
                        instruccion.getDescripcion()
                ))
                .toList();
    }

    @Override
    public Instrucciones agregarInstruccion(Integer idReceta, Instrucciones instruccion) {
        Receta receta = obtenerRecetaPorId(idReceta);
        instruccion.setReceta(receta);
        return instruccionesRepository.save(instruccion);
    }


    ///Ingrediente Por Receta
    @Override
    public RecetaHasIngredientes agregarIngredienteAReceta(Integer idReceta, RecetaHasIngredienteDto request) {

        Receta receta = recetaRepository.findById(idReceta)
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));

        Ingrediente ingrediente = ingredienteRepository.findById(request.getIdIngrediente())
                .orElseThrow(() -> new RuntimeException("Ingrediente no encontrado"));

        RecetaHasIngredientePK pk = new RecetaHasIngredientePK();
        pk.setIdReceta(idReceta);
        pk.setIdIngrediente(request.getIdIngrediente());

        RecetaHasIngredientes relacion = new RecetaHasIngredientes();
        relacion.setRecetaHasIngredientePK(pk);
        relacion.setReceta(receta);
        relacion.setIngrediente(ingrediente);

        return recetaHasIngredienteRepository.save(relacion);
    }

    @Override
    public RecetaDto obtenerRecetarioPorId(Integer idReceta) {

        Receta receta = recetaRepository.findById(idReceta)
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));

        List<RecetaHasIngredientes> relaciones =
                recetaHasIngredienteRepository.findByReceta(receta);

        List<Integer> ingrediente = relaciones.stream()
                .map(relacion -> relacion.getIngrediente().getIdIngrediente())
                .toList();

        return new RecetaDto(
                receta.getIdReceta(),
                receta.getTitulo(),
                ingrediente
        );
    }
}

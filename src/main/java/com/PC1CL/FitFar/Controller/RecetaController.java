package com.PC1CL.FitFar.Controller;

import com.PC1CL.FitFar.Entity.Instrucciones;
import com.PC1CL.FitFar.Entity.Receta;
import com.PC1CL.FitFar.Entity.RecetaHasIngredientes;
import com.PC1CL.FitFar.Service.RecetaService;
import com.PC1CL.FitFar.dto.InstruccionesDto;
import com.PC1CL.FitFar.dto.RecetaDto;
import com.PC1CL.FitFar.dto.RecetaHasIngredienteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recetas")
@RequiredArgsConstructor
public class RecetaController {

    private final RecetaService recetaService;

    @GetMapping
    public List<Receta> listarRecetas() {
        return recetaService.listarRecetas();
    }

    @GetMapping("/{id}")
    public Receta obtenerRecetaPorId(@PathVariable Integer id) {
        return recetaService.obtenerRecetaPorId(id);
    }

    @PostMapping
    public Receta registrarReceta(@RequestBody Receta receta) {
        return recetaService.registrarReceta(receta);
    }

    @PutMapping("/{id}")
    public Receta actualizarReceta(@PathVariable Integer id,
                                   @RequestBody Receta receta) {
        return recetaService.actualizarReceta(id, receta);
    }

    @DeleteMapping("/{id}")
    public void eliminarReceta(@PathVariable Integer id) {
        recetaService.eliminarReceta(id);
    }

    @GetMapping("/categoria/{idCategoria}")
    public List<Receta> listarPorCategoria(@PathVariable Integer idCategoria) {
        return recetaService.listarPorCategoria(idCategoria);
    }

    @GetMapping("/pais/{idPais}")
    public List<Receta> listarPorPais(@PathVariable Integer idPais) {
        return recetaService.listarPorPais(idPais);
    }


    @GetMapping("/{idReceta}/instrucciones")
    public List<InstruccionesDto> listarInstruccionesPorReceta(@PathVariable Integer idReceta) {
        return recetaService.listarInstruccionesPorReceta(idReceta);
    }

    @PostMapping("/{idReceta}/instrucciones")
    public Instrucciones agregarInstruccion(@PathVariable Integer idReceta,
                                            @RequestBody Instrucciones instruccion) {
        return recetaService.agregarInstruccion(idReceta, instruccion);
    }

    @PostMapping("/{idReceta}/ingredientes")
    public RecetaHasIngredientes agregarIngredienteAReceta(
            @PathVariable Integer idReceta,
            @RequestBody RecetaHasIngredienteDto request) {

        return recetaService.agregarIngredienteAReceta(idReceta, request);
    }

    @GetMapping("/{idReceta}/detalle")
    public RecetaDto obtenerRecetaDtoPorId(@PathVariable Integer idReceta) {
        return recetaService.obtenerRecetarioPorId(idReceta);
    }
}

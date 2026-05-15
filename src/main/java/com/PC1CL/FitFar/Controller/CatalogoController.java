package com.PC1CL.FitFar.Controller;

import com.PC1CL.FitFar.Entity.Categoria;
import com.PC1CL.FitFar.Entity.Ingrediente;
import com.PC1CL.FitFar.Entity.Pais;
import com.PC1CL.FitFar.Service.CatalogoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogos")
@RequiredArgsConstructor
public class CatalogoController {

    private final CatalogoService catalogoService;

    @GetMapping("/categorias")
    public List<Categoria> listarCategorias() {
        return catalogoService.listarCategorias();
    }

    @PostMapping("/categorias")
    public Categoria registrarCategoria(@RequestBody Categoria categoria) {
        return catalogoService.registrarCategoria(categoria);
    }

    @DeleteMapping("/categorias/{idCategoria}")
    public void eliminarCategoria(@PathVariable Integer idCategoria) {
        catalogoService.eliminarCategoria(idCategoria);
    }

    @GetMapping("/paises")
    public List<Pais> listarPaises() {
        return catalogoService.listarPaises();
    }

    @PostMapping("/paises")
    public Pais registrarPais(@RequestBody Pais pais) {
        return catalogoService.registrarPais(pais);
    }

    @DeleteMapping("/paises/{idPais}")
    public void eliminarPais(@PathVariable Integer idPais) {
        catalogoService.eliminarPais(idPais);
    }

    @GetMapping("/ingredientes")
    public List<Ingrediente> listarIngredientes() {
        return catalogoService.listarIngredientes();
    }

    @PostMapping("/ingredientes")
    public Ingrediente registrarIngrediente(@RequestBody Ingrediente ingrediente) {
        return catalogoService.registrarIngrediente(ingrediente);
    }

    @DeleteMapping("/ingrediente/{idIngrediente}")
    public void eliminarIngrediente(@PathVariable Integer idIngrediente) {
        catalogoService.eliminarIngrediente(idIngrediente);
    }
}

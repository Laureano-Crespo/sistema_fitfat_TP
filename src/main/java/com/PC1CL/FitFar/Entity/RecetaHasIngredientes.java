package com.PC1CL.FitFar.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "receta_has_ingrediente")
public class RecetaHasIngredientes {

    @EmbeddedId
    private RecetaHasIngredientePK recetaHasIngredientePK;

    @ManyToOne
    @JoinColumn(name = "idReceta", nullable = false, insertable = false, updatable = false)
    private Receta receta;

    @ManyToOne
    @JoinColumn(name = "idIngrediente", nullable = false, insertable = false, updatable = false)
    private Ingrediente ingrediente;

}

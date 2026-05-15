package com.PC1CL.FitFar.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "favorito")
public class Favorito {

    @EmbeddedId
    private FavoritoPK favoritosPK;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false, insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idReceta", nullable = false, insertable = false, updatable = false)
    private Receta receta;

}

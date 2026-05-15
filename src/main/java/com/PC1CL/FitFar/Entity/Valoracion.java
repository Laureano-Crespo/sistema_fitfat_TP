package com.PC1CL.FitFar.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "valoracion")
public class Valoracion {

    @EmbeddedId
    private ValoracionPK valoracionPK;

    @ManyToOne
    @JoinColumn(name = "idReceta", nullable = false, insertable = false, updatable = false)
    private Receta receta;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false, insertable = false, updatable = false)
    private Usuario usuario;

    private int puntuacion;

}
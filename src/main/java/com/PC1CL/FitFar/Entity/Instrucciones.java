package com.PC1CL.FitFar.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "instrucciones")
public class Instrucciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInstrucciones;

    private String numeroPaso;
    private String descripcion;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idReceta")
    private Receta receta;

}
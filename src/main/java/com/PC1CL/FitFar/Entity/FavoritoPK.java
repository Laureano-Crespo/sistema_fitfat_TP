package com.PC1CL.FitFar.Entity;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class FavoritoPK implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idUsuario;
    private int idReceta;

}

package com.PC1CL.FitFar.dto;
import com.PC1CL.FitFar.Entity.FavoritoPK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FavoritoDto {

    private FavoritoPK favoritoPK;
    private RecetaDto receta;
    private UsuarioDto usuario;
}

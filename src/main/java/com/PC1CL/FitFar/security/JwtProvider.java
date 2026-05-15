package com.PC1CL.FitFar.security;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.PC1CL.FitFar.Entity.Opcion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    private String secret = "secret";
    private int expiration = 36000;

    // Método original (lo dejamos para compatibilidad)
    public String generateToken(Authentication authentication){
        logger.info(">>> generateToken" );
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        return generateTokenWithClaims(usuarioPrincipal);
    }

    // Nuevo método que incluye roles y opciones en el token
    public String generateTokenWithClaims(UsuarioPrincipal usuarioPrincipal){
        logger.info(">>> generateTokenWithClaims" );

        Map<String, Object> claims = new HashMap<>();

        // Información básica del usuario
        claims.put("idUsuario", usuarioPrincipal.getIdUsuario());
        claims.put("nombreCompleto", usuarioPrincipal.getNombreCompleto());
        claims.put("login", usuarioPrincipal.getLogin());

        // Agregar roles (nombres)
        List<String> rolesNombres = usuarioPrincipal.getAuthorities().stream().map(auth -> auth.getAuthority()).collect(Collectors.toList());
        claims.put("roles", rolesNombres);

        // Agregar opciones
        if (usuarioPrincipal.getOpciones() != null) {
            List<Opcion> lstOpciones = usuarioPrincipal.getOpciones();
            claims.put("opciones", lstOpciones);
        }

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            logger.error(">>> validateToken >>> token mal formado");
        }catch (UnsupportedJwtException e){
            logger.error(">>> validateToken >>> token no soportado");
        }catch (ExpiredJwtException e){
            logger.error(">>> validateToken >>> token expirado");
        }catch (IllegalArgumentException e){
            logger.error(">>> validateToken >>> token vacío");
        }catch (SignatureException e){
            logger.error(">>> validateToken >>> fail en la firma");
        }
        return false;
    }
}
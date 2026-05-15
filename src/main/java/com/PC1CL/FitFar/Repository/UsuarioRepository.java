package com.PC1CL.FitFar.Repository;

import com.PC1CL.FitFar.Entity.Opcion;
import com.PC1CL.FitFar.Entity.Rol;
import com.PC1CL.FitFar.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    @Query("SELECT u FROM Usuario u WHERE u.loggin = :login AND u.clave = :password")
    Optional<Usuario> login(@Param("login") String login, @Param("password") String password);

    @Query("SELECT p FROM Opcion p, RolHasOpcion ro, Rol r, UsuarioHasRol ur WHERE p.idOpcion = ro.opcion.idOpcion AND ro.rol.idRol = r.idRol AND r.idRol = ur.rol.idRol AND ur.usuario.idUsuario = :idUsuario")
    List<Opcion> traerEnlacesDeUsuario(@Param("idUsuario") Integer idUsuario);

    @Query("SELECT DISTINCT r FROM Rol r, UsuarioHasRol ur WHERE r.idRol = ur.rol.idRol AND ur.usuario.idUsuario = :idUsuario")
    List<Rol> traerRolesDeUsuario(@Param("idUsuario") int idUsuario);

    List<Usuario> findByDni(String dni);

    Optional<Usuario> findByLoggin(String loggin);
}

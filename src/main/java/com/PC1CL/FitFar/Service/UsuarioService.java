package com.PC1CL.FitFar.Service;

import com.PC1CL.FitFar.Entity.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listarUsuarios();

    Usuario obtenerUsuarioPorId(Integer id);

    Usuario registrarUsuario(Usuario usuario);

    Usuario actualizarUsuario(Integer id, Usuario usuario);

    void eliminarUsuario(Integer id);
}
package com.PC1CL.FitFar.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PC1CL.FitFar.Entity.Usuario;
import com.PC1CL.FitFar.Repository.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    @Override
    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }

    @Override
    public Usuario obtenerUsuarioPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Integer id, Usuario usuario) {
        Usuario usuarioExistente = obtenerUsuarioPorId(id);

        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setClave(usuario.getClave());
        usuarioExistente.setEstado(usuario.getEstado());

        return repository.save(usuarioExistente);
    }

    @Override
    public void eliminarUsuario(Integer id) {
        Usuario usuario = obtenerUsuarioPorId(id);
        repository.delete(usuario);
    }
}
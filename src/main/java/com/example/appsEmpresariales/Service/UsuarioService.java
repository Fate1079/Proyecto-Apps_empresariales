package com.example.appsEmpresariales.Service;

import com.example.appsEmpresariales.Repitory.UsuarioRepository;
import com.example.appsEmpresariales.dto.UsuarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // -------- CRUD --------
    public UsuarioDTO guardarUsuario(UsuarioDTO usuario) {
        return usuarioRepository.save(usuario);
    }

    public UsuarioDTO obtenerUsuarioPorId(String id) {
        return usuarioRepository.findById(id);
    }

    public List<UsuarioDTO> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public void eliminarUsuario(String id) {
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO actualizarUsuario(UsuarioDTO usuario) {
        return usuarioRepository.update(usuario);
    }

    // -------- Búsquedas --------
    public List<UsuarioDTO> obtenerUsuariosPorRol(String rol) {
        return usuarioRepository.findByRol(rol);
    }

    public boolean existeUsuarioPorEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }
}

package com.example.appsEmpresariales.Repitory;


import com.example.appsEmpresariales.dto.UsuarioDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    private final List<UsuarioDTO> baseDeDatos = new ArrayList<>();

    public UsuarioDTO save(UsuarioDTO usuario) {
        baseDeDatos.add(usuario);
        return usuario;
    }

    public UsuarioDTO findById(String id) {
        for (UsuarioDTO usuario : baseDeDatos) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public List<UsuarioDTO> findAll() {
        return new ArrayList<>(baseDeDatos);
    }

    public void deleteById(String id) {
        baseDeDatos.removeIf(usuario -> usuario.getId().equals(id));
    }

    public UsuarioDTO update(UsuarioDTO usuario) {
        for (int i = 0; i < baseDeDatos.size(); i++) {
            if (baseDeDatos.get(i).getId().equals(usuario.getId())) {
                baseDeDatos.set(i, usuario);
                return usuario;
            }
        }
        return null;
    }

    public List<UsuarioDTO> findByRol(String rol) {
        List<UsuarioDTO> resultado = new ArrayList<>();
        for (UsuarioDTO usuario : baseDeDatos) {
            if (usuario.getRol() != null && usuario.getRol().equals(rol)) {
                resultado.add(usuario);
            }
        }
        return resultado;
    }

    public boolean existsByEmail(String email) {
        return baseDeDatos.stream().anyMatch(u -> email.equals(u.getEmail()));
    }
}

package com.example.appsEmpresariales.Repitory;

import com.example.appsEmpresariales.dto.RecursoDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecursoRepository {

    private final List<RecursoDTO> baseDeDatos = new ArrayList<>();

    public RecursoDTO save(RecursoDTO recurso) {
        baseDeDatos.add(recurso);
        return recurso;
    }

    public RecursoDTO findById(String id) {
        for (RecursoDTO recurso : baseDeDatos) {
            if (recurso.getId().equals(id)) {
                return recurso;
            }
        }
        return null;
    }

    public List<RecursoDTO> findAll() {
        return new ArrayList<>(baseDeDatos);
    }

    public void deleteById(String id) {
        baseDeDatos.removeIf(recurso -> recurso.getId().equals(id));
    }

    public RecursoDTO update(RecursoDTO recurso) {
        for (int i = 0; i < baseDeDatos.size(); i++) {
            if (baseDeDatos.get(i).getId().equals(recurso.getId())) {
                baseDeDatos.set(i, recurso);
                return recurso;
            }
        }
        return null;
    }

    public List<RecursoDTO> findByTipo(String tipo) {
        List<RecursoDTO> resultado = new ArrayList<>();
        for (RecursoDTO recurso : baseDeDatos) {
            if (tipo.equals(recurso.getTipo())) {
                resultado.add(recurso);
            }
        }
        return resultado;
    }

    public List<RecursoDTO> findByEstado(String estado) {
        List<RecursoDTO> resultado = new ArrayList<>();
        for (RecursoDTO recurso : baseDeDatos) {
            if (estado.equals(recurso.getEstado())) {
                resultado.add(recurso);
            }
        }
        return resultado;
    }
}

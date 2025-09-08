package com.example.appsEmpresariales.Service;

import com.example.appsEmpresariales.Repitory.RecursoRepository;
import com.example.appsEmpresariales.dto.RecursoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoService {

    private final RecursoRepository recursoRepository;

    public RecursoService(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    public RecursoDTO guardarRecurso(RecursoDTO recurso) {
        return recursoRepository.save(recurso);
    }

    public RecursoDTO obtenerRecursoPorId(String id) {
        return recursoRepository.findById(id);
    }

    public List<RecursoDTO> obtenerTodosLosRecursos() {
        return recursoRepository.findAll();
    }

    public void eliminarRecurso(String id) {
        recursoRepository.deleteById(id);
    }

    public RecursoDTO actualizarRecurso(RecursoDTO recurso) {
        return recursoRepository.update(recurso);
    }

    public List<RecursoDTO> obtenerRecursosPorTipo(String tipo) {
        return recursoRepository.findByTipo(tipo);
    }

    public List<RecursoDTO> obtenerRecursosPorEstado(String estado) {
        return recursoRepository.findByEstado(estado);
    }
}

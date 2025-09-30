package com.example.appsEmpresariales.Service;

import com.example.appsEmpresariales.Entity.RecursoEntity;
import com.example.appsEmpresariales.Repository.RecursoRepository;
import com.example.appsEmpresariales.dto.RecursoDTO;
import com.example.appsEmpresariales.Mapper.RecursoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecursoService {

    private final RecursoRepository recursoRepository;
    private final RecursoMapper recursoMapper;

    public RecursoService(RecursoRepository recursoRepository, RecursoMapper recursoMapper) {
        this.recursoRepository = recursoRepository;
        this.recursoMapper = recursoMapper;
    }

    public RecursoDTO guardarRecurso(RecursoDTO recurso) {
        RecursoEntity entity = recursoMapper.toEntity(recurso);
        RecursoEntity guardado = recursoRepository.save(entity);
        return recursoMapper.toDto(guardado);
    }

    public RecursoDTO obtenerRecursoPorId(String id) {
        return recursoRepository.findById(id)
                .map(recursoMapper::toDto)
                .orElse(null);
    }

    public List<RecursoDTO> obtenerTodosLosRecursos() {
        return recursoRepository.findAll()
                .stream()
                .map(recursoMapper::toDto)
                .collect(Collectors.toList());
    }

    public void eliminarRecurso(String id) {
        recursoRepository.deleteById(id);
    }

    public RecursoDTO actualizarRecurso(RecursoDTO recurso) {
        if (recursoRepository.existsById(recurso.getId())) {
            RecursoEntity entity = recursoMapper.toEntity(recurso);
            RecursoEntity actualizado = recursoRepository.save(entity);
            return recursoMapper.toDto(actualizado);
        }
        return null;
    }

    public List<RecursoDTO> obtenerRecursosPorTipo(String tipo) {
        return recursoRepository.findByTipo(tipo)
                .stream()
                .map(recursoMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<RecursoDTO> obtenerRecursosPorEstado(String estado) {
        return recursoRepository.findByEstado(estado)
                .stream()
                .map(recursoMapper::toDto)
                .collect(Collectors.toList());
    }
}

package com.example.appsEmpresariales.Mapper;

import com.example.appsEmpresariales.Entity.RecursoEntity;
import com.example.appsEmpresariales.dto.RecursoDTO;

public class RecursoMapper {

    // DTO → Entity
    public static RecursoEntity toEntity(RecursoDTO dto) {
        if (dto == null) return null;

        return new RecursoEntity(
                dto.getId(),
                dto.getNombre(),
                dto.getTipo(),
                dto.getCapacidad(),
                dto.getUbicacion(),
                dto.getEstado()
        );
    }

    // Entity → DTO
    public static RecursoDTO toDTO(RecursoEntity entity) {
        if (entity == null) return null;

        return new RecursoDTO(
                entity.getId(),
                entity.getNombre(),
                entity.getTipo(),
                entity.getCapacidad(),
                entity.getUbicacion(),
                entity.getEstado()
        );
    }
}

package com.example.appsEmpresariales.Mapper;

import com.example.appsEmpresariales.Entity.ReservaEntity;
import com.example.appsEmpresariales.dto.ReservaDTO;

public class ReservaMapper {

    // DTO → Entity
    public static ReservaEntity toEntity(ReservaDTO dto) {
        if (dto == null) return null;

        return new ReservaEntity(
                dto.getId(),
                dto.getUsuario(),
                dto.getRecurso(),
                dto.getEstado(),
                dto.getAsiento(),
                dto.getPrecio(),
                dto.getFechaInicio(),
                dto.getFechaFin()
        );
    }

    // Entity → DTO
    public static ReservaDTO toDTO(ReservaEntity entity) {
        if (entity == null) return null;

        return new ReservaDTO(
                entity.getId(),
                entity.getUsuario(),
                entity.getRecurso(),
                entity.getEstado(),
                entity.getAsiento(),
                entity.getPrecio(),
                entity.getFechaInicio(),
                entity.getFechaFin()
        );
    }
}

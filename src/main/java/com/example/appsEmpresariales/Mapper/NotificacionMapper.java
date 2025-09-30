package com.example.appsEmpresariales.Mapper;

import com.example.appsEmpresariales.Entity.NotificacionEntity;
import com.example.appsEmpresariales.dto.NotificacionDTO;

public class NotificacionMapper {

    // DTO → Entity
    public static NotificacionEntity toEntity(NotificacionDTO dto) {
        if (dto == null) return null;

        return new NotificacionEntity(
                dto.getId(),
                dto.getMensaje(),
                dto.getTipo(),
                dto.getFechaEnvio(),
                dto.getIdUsuario()
        );
    }

    // Entity → DTO
    public static NotificacionDTO toDTO(NotificacionEntity entity) {
        if (entity == null) return null;

        return new NotificacionDTO(
                entity.getId(),
                entity.getMensaje(),
                entity.getTipo(),
                entity.getFechaEnvio(),
                entity.getIdUsuario()
        );
    }
}

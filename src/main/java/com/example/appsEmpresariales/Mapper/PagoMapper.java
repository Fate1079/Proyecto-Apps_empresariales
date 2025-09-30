package com.example.appsEmpresariales.Mapper;

import com.example.appsEmpresariales.Entity.PagoEntity;
import com.example.appsEmpresariales.dto.PagoDTO;

public class PagoMapper {

    // DTO → Entity
    public static PagoEntity toEntity(PagoDTO dto) {
        if (dto == null) return null;

        return new PagoEntity(
                dto.getId(),
                dto.getMonto(),
                dto.getFechaPago(),
                dto.getMetodoPago(),
                dto.getEstadoPago(),
                dto.getIdReserva()
        );
    }

    // Entity → DTO
    public static PagoDTO toDTO(PagoEntity entity) {
        if (entity == null) return null;

        return new PagoDTO(
                entity.getId(),
                entity.getMonto(),
                entity.getFechaPago(),
                entity.getMetodoPago(),
                entity.getEstadoPago(),
                entity.getIdReserva()
        );
    }
}

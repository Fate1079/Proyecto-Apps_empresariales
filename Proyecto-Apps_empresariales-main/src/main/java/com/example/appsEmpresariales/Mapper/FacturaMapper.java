package com.example.appsEmpresariales.Mapper;

import com.example.appsEmpresariales.Entity.FacturaEntity;
import com.example.appsEmpresariales.dto.FacturaDTO;

public class FacturaMapper {

    // DTO → Entity
    public static FacturaEntity toEntity(FacturaDTO dto) {
        if (dto == null) return null;

        return new FacturaEntity(
                dto.getId(),
                dto.getNumeroFactura(),
                dto.getFechaEmision(),
                dto.getTotal(),
                dto.getIdPago()
        );
    }

    // Entity → DTO
    public static FacturaDTO toDTO(FacturaEntity entity) {
        if (entity == null) return null;

        return new FacturaDTO(
                entity.getId(),
                entity.getNumeroFactura(),
                entity.getFechaEmision(),
                entity.getTotal(),
                entity.getIdPago()
        );
    }
}

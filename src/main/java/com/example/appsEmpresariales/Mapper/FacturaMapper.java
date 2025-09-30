package com.example.appsEmpresariales.Mapper;

import com.example.appsEmpresariales.dto.FacturaDTO;
import com.example.appsEmpresariales.Entity.FacturaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacturaMapper {
    FacturaDTO toDto(FacturaEntity entity);
    FacturaEntity toEntity(FacturaDTO dto);
}

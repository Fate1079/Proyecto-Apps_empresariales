package com.example.appsEmpresariales.Mapper;

import com.example.appsEmpresariales.Entity.PagoEntity;
import com.example.appsEmpresariales.dto.PagoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PagoMapper {
    PagoDTO toDto(PagoEntity entity);
    PagoEntity toEntity(PagoDTO dto);
}

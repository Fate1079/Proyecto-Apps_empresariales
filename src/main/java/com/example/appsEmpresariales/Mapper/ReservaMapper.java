package com.example.appsEmpresariales.Mapper;

import com.example.appsEmpresariales.Entity.ReservaEntity;
import com.example.appsEmpresariales.dto.ReservaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservaMapper {
    ReservaDTO toDto(ReservaEntity entity);
    ReservaEntity toEntity(ReservaDTO dto);
}

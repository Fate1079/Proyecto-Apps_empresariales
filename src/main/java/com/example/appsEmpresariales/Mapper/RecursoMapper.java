package com.example.appsEmpresariales.Mapper;

import com.example.appsEmpresariales.Entity.RecursoEntity;
import com.example.appsEmpresariales.dto.RecursoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecursoMapper {
    RecursoDTO toDto(RecursoEntity entity);
    RecursoEntity toEntity(RecursoDTO dto);
}

package com.example.appsEmpresariales.Mapper;

import com.example.appsEmpresariales.Entity.NotificacionEntity;
import com.example.appsEmpresariales.dto.NotificacionDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificacionMapper {
    NotificacionDTO toDto(NotificacionEntity entity);
    NotificacionEntity toEntity(NotificacionDTO dto);
}

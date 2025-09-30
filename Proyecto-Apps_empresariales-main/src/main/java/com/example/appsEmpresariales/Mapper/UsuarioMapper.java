
package com.example.appsEmpresariales.Mapper;

import com.example.appsEmpresariales.Entity.UsuarioEntity;
import com.example.appsEmpresariales.dto.UsuarioDTO;

public class UsuarioMapper {

    // DTO → Entity
    public static UsuarioEntity toEntity(UsuarioDTO dto) {
        if (dto == null) return null;

        return new UsuarioEntity(
                dto.getId(),
                dto.getNombre(),
                dto.getApellido(),
                dto.getEmail(),
                dto.getContraseña(),
                dto.getRol()
        );
    }

    // Entity → DTO
    public static UsuarioDTO toDTO(UsuarioEntity entity) {
        if (entity == null) return null;

        return new UsuarioDTO(
                entity.getId(),
                entity.getNombre(),
                entity.getApellido(),
                entity.getEmail(),
                entity.getContraseña(),
                entity.getRol()
        );
    }
}

package com.example.appsEmpresariales.Repitory;


import com.example.appsEmpresariales.dto.NotificacionDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NotificacionRepository {

    private final List<NotificacionDTO> baseDeDatos = new ArrayList<>();

    public NotificacionDTO save(NotificacionDTO notificacion) {
        baseDeDatos.add(notificacion);
        return notificacion;
    }

    public List<NotificacionDTO> findByUsuario(String idUsuario) {
        List<NotificacionDTO> resultado = new ArrayList<>();
        for (NotificacionDTO notificacion : baseDeDatos) {
            if (idUsuario.equals(notificacion.getIdUsuario())) {
                resultado.add(notificacion);
            }
        }
        return resultado;
    }

    public List<NotificacionDTO> findByTipo(String tipo) {
        List<NotificacionDTO> resultado = new ArrayList<>();
        for (NotificacionDTO notificacion : baseDeDatos) {
            if (tipo.equals(notificacion.getTipo())) {
                resultado.add(notificacion);
            }
        }
        return resultado;
    }

    public List<NotificacionDTO> findAll() {
        return new ArrayList<>(baseDeDatos);
    }

    public void deleteById(String id) {
        baseDeDatos.removeIf(n -> n.getId().equals(id));
    }
}

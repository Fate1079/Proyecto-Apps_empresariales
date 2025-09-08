package com.example.appsEmpresariales.Service;

import com.example.appsEmpresariales.Repitory.NotificacionRepository;
import com.example.appsEmpresariales.dto.NotificacionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;

    public NotificacionService(NotificacionRepository notificacionRepository) {
        this.notificacionRepository = notificacionRepository;
    }

    public NotificacionDTO guardarNotificacion(NotificacionDTO notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public List<NotificacionDTO> obtenerNotificacionesPorUsuario(String idUsuario) {
        return notificacionRepository.findByUsuario(idUsuario);
    }

    public List<NotificacionDTO> obtenerNotificacionesPorTipo(String tipo) {
        return notificacionRepository.findByTipo(tipo);
    }

    public List<NotificacionDTO> obtenerTodas() {
        return notificacionRepository.findAll();
    }

    public void eliminarNotificacion(String id) {
        notificacionRepository.deleteById(id);
    }
}

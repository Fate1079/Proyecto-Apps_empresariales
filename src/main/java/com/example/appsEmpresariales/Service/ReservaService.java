package com.example.appsEmpresariales.Service;

import com.example.appsEmpresariales.Repitory.ReservaRepository;
import com.example.appsEmpresariales.dto.ReservaDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    // -------- CRUD --------
    public ReservaDTO guardarReserva(ReservaDTO reserva) {
        return reservaRepository.save(reserva);
    }

    public ReservaDTO obtenerReservaPorId(String id) {
        return reservaRepository.findById(id);
    }

    public List<ReservaDTO> obtenerTodasLasReservas() {
        return reservaRepository.findAll();
    }

    public void eliminarReserva(String id) {
        reservaRepository.deleteById(id);
    }

    public ReservaDTO actualizarReserva(ReservaDTO reserva) {
        return reservaRepository.update(reserva);
    }

    // -------- Búsquedas --------
    public List<ReservaDTO> obtenerReservasPorUsuario(String usuario) {
        return reservaRepository.findByUsuario(usuario);
    }

    public List<ReservaDTO> obtenerReservasPorEstado(String estado) {
        return reservaRepository.findByEstado(estado);
    }

    public List<ReservaDTO> obtenerReservasPorRecurso(String recurso) {
        return reservaRepository.findByRecurso(recurso);
    }

    public List<ReservaDTO> obtenerReservasPorRangoFechas(LocalDate inicio, LocalDate fin) {
        return reservaRepository.findByRangoFechas(inicio, fin);
    }

    // -------- Utilitarios --------
    public boolean existeReserva(String id) {
        return reservaRepository.existsById(id);
    }

    public long contarReservas() {
        return reservaRepository.count();
    }

    public long contarReservasPorEstado(String estado) {
        return reservaRepository.countByEstado(estado);
    }
}

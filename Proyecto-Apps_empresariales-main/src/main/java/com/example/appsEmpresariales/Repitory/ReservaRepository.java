package com.example.appsEmpresariales.Repitory;


import com.example.appsEmpresariales.dto.ReservaDTO;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservaRepository {

    private final List<ReservaDTO> baseDeDatos = new ArrayList<>();

    // -------- CRUD --------
    public ReservaDTO save(ReservaDTO reserva) {
        baseDeDatos.add(reserva);
        return reserva;
    }

    public ReservaDTO findById(String id) {
        for (ReservaDTO reserva : baseDeDatos) {
            if (reserva.getId().equals(id)) {
                return reserva;
            }
        }
        return null;
    }

    public List<ReservaDTO> findAll() {
        return new ArrayList<>(baseDeDatos);
    }

    public void deleteById(String id) {
        baseDeDatos.removeIf(reserva -> reserva.getId().equals(id));
    }

    public ReservaDTO update(ReservaDTO reserva) {
        for (int i = 0; i < baseDeDatos.size(); i++) {
            if (baseDeDatos.get(i).getId().equals(reserva.getId())) {
                baseDeDatos.set(i, reserva);
                return reserva;
            }
        }
        return null;
    }

    // -------- Métodos de búsqueda --------
    public List<ReservaDTO> findByUsuario(String usuario) {
        List<ReservaDTO> resultado = new ArrayList<>();
        for (ReservaDTO reserva : baseDeDatos) {
            if (reserva.getUsuario() != null && reserva.getUsuario().contains(usuario)) {
                resultado.add(reserva);
            }
        }
        return resultado;
    }

    public List<ReservaDTO> findByEstado(String estado) {
        List<ReservaDTO> resultado = new ArrayList<>();
        for (ReservaDTO reserva : baseDeDatos) {
            if (estado.equalsIgnoreCase(reserva.getEstado())) {
                resultado.add(reserva);
            }
        }
        return resultado;
    }

    public List<ReservaDTO> findByRecurso(String recurso) {
        List<ReservaDTO> resultado = new ArrayList<>();
        for (ReservaDTO reserva : baseDeDatos) {
            if (reserva.getRecurso() != null && reserva.getRecurso().equalsIgnoreCase(recurso)) {
                resultado.add(reserva);
            }
        }
        return resultado;
    }

    public List<ReservaDTO> findByRangoFechas(LocalDate inicio, LocalDate fin) {
        List<ReservaDTO> resultado = new ArrayList<>();
        for (ReservaDTO reserva : baseDeDatos) {
            boolean solapa = !(reserva.getFechaFin().isBefore(inicio) || reserva.getFechaInicio().isAfter(fin));
            if (solapa) {
                resultado.add(reserva);
            }
        }
        return resultado;
    }

    // -------- Utilitarios --------
    public boolean existsById(String id) {
        return findById(id) != null;
    }

    public long count() {
        return baseDeDatos.size();
    }

    public long countByEstado(String estado) {
        return baseDeDatos.stream().filter(r -> estado.equalsIgnoreCase(r.getEstado())).count();
    }
}


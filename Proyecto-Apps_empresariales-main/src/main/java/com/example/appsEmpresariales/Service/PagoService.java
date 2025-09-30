package com.example.appsEmpresariales.Service;

import com.example.appsEmpresariales.Repitory.PagoRepository;
import com.example.appsEmpresariales.dto.PagoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    private final PagoRepository pagoRepository;

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public PagoDTO guardarPago(PagoDTO pago) {
        return pagoRepository.save(pago);
    }

    public PagoDTO obtenerPagoPorId(String id) {
        return pagoRepository.findById(id);
    }

    public List<PagoDTO> obtenerTodosLosPagos() {
        return pagoRepository.findAll();
    }

    public void eliminarPago(String id) {
        pagoRepository.deleteById(id);
    }

    public PagoDTO actualizarPago(PagoDTO pago) {
        return pagoRepository.update(pago);
    }

    public List<PagoDTO> obtenerPagosPorEstado(String estado) {
        return pagoRepository.findByEstado(estado);
    }
}

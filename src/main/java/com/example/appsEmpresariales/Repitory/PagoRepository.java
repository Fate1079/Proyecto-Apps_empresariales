package com.example.appsEmpresariales.Repitory;


import com.example.appsEmpresariales.dto.PagoDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PagoRepository {

    private final List<PagoDTO> baseDeDatos = new ArrayList<>();

    public PagoDTO save(PagoDTO pago) {
        baseDeDatos.add(pago);
        return pago;
    }

    public PagoDTO findById(String id) {
        for (PagoDTO pago : baseDeDatos) {
            if (pago.getId().equals(id)) {
                return pago;
            }
        }
        return null;
    }

    public List<PagoDTO> findAll() {
        return new ArrayList<>(baseDeDatos);
    }

    public void deleteById(String id) {
        baseDeDatos.removeIf(pago -> pago.getId().equals(id));
    }

    public PagoDTO update(PagoDTO pago) {
        for (int i = 0; i < baseDeDatos.size(); i++) {
            if (baseDeDatos.get(i).getId().equals(pago.getId())) {
                baseDeDatos.set(i, pago);
                return pago;
            }
        }
        return null;
    }

    public List<PagoDTO> findByEstado(String estado) {
        List<PagoDTO> resultado = new ArrayList<>();
        for (PagoDTO pago : baseDeDatos) {
            if (estado.equals(pago.getEstadoPago())) {
                resultado.add(pago);
            }
        }
        return resultado;
    }
}

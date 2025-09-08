package com.example.appsEmpresariales.Repitory;


import com.example.appsEmpresariales.dto.FacturaDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FacturaRepository {

    private final List<FacturaDTO> baseDeDatos = new ArrayList<>();

    public FacturaDTO save(FacturaDTO factura) {
        baseDeDatos.add(factura);
        return factura;
    }

    public FacturaDTO findById(String id) {
        for (FacturaDTO factura : baseDeDatos) {
            if (factura.getId().equals(id)) {
                return factura;
            }
        }
        return null;
    }

    public List<FacturaDTO> findAll() {
        return new ArrayList<>(baseDeDatos);
    }

    public void deleteById(String id) {
        baseDeDatos.removeIf(factura -> factura.getId().equals(id));
    }

    public FacturaDTO update(FacturaDTO factura) {
        for (int i = 0; i < baseDeDatos.size(); i++) {
            if (baseDeDatos.get(i).getId().equals(factura.getId())) {
                baseDeDatos.set(i, factura);
                return factura;
            }
        }
        return null;
    }

    public FacturaDTO findByNumeroFactura(String numeroFactura) {
        for (FacturaDTO factura : baseDeDatos) {
            if (factura.getNumeroFactura().equals(numeroFactura)) {
                return factura;
            }
        }
        return null;
    }
}

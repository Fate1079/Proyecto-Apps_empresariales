package com.example.appsEmpresariales.Service;

import com.example.appsEmpresariales.Repitory.FacturaRepository;
import com.example.appsEmpresariales.dto.FacturaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {

    private final FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    // -------- CRUD --------
    public FacturaDTO save(FacturaDTO factura) {
        return facturaRepository.save(factura);
    }

    public FacturaDTO findById(String id) {
        return facturaRepository.findById(id);
    }

    public List<FacturaDTO> findAll() {
        return facturaRepository.findAll();
    }

    public FacturaDTO update(FacturaDTO factura) {
        return facturaRepository.update(factura);
    }

    public void deleteById(String id) {
        facturaRepository.deleteById(id);
    }

    // -------- Búsquedas específicas --------
    public FacturaDTO findByNumeroFactura(String numeroFactura) {
        return facturaRepository.findByNumeroFactura(numeroFactura);
    }
}

package com.example.appsEmpresariales.Controller;

import com.example.appsEmpresariales.Service.FacturaService;
import com.example.appsEmpresariales.dto.FacturaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
@Tag(name = "facturas", description = "API para la gestión de facturas")
public class FacturaController {

    private final FacturaService facturaService;

    @Autowired
    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    // -------- CRUD --------
    @GetMapping
    @Operation(summary = "Obtener todas las facturas")
    @ApiResponse(responseCode = "200", description = "Facturas obtenidas con éxito")
    public ResponseEntity<List<FacturaDTO>> getAllFacturas() {
        return ResponseEntity.ok(facturaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una factura por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Factura encontrada"),
            @ApiResponse(responseCode = "404", description = "Factura no encontrada")
    })
    public ResponseEntity<FacturaDTO> getFacturaById(
            @PathVariable @Parameter(description = "ID de la factura") String id) {
        FacturaDTO factura = facturaService.findById(id);
        return factura != null ? ResponseEntity.ok(factura) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Crear una nueva factura")
    @ApiResponse(responseCode = "201", description = "Factura creada exitosamente")
    public ResponseEntity<FacturaDTO> crearFactura(
            @RequestBody @Parameter(description = "Datos de la factura a crear") FacturaDTO factura) {
        return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.save(factura));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una factura existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Factura actualizada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Factura no encontrada")
    })
    public ResponseEntity<FacturaDTO> actualizarFactura(
            @PathVariable String id,
            @RequestBody FacturaDTO factura) {
        factura.setId(id);
        FacturaDTO actualizada = facturaService.update(factura);
        return actualizada != null ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una factura por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Factura eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Factura no encontrada")
    })
    public ResponseEntity<Void> eliminarFactura(@PathVariable String id) {
        facturaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // -------- Búsqueda específica --------
    @GetMapping("/numero/{numeroFactura}")
    @Operation(summary = "Obtener una factura por número de factura")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Factura encontrada"),
            @ApiResponse(responseCode = "404", description = "Factura no encontrada")
    })
    public ResponseEntity<FacturaDTO> getFacturaByNumero(
            @PathVariable @Parameter(description = "Número de la factura") String numeroFactura) {
        FacturaDTO factura = facturaService.findByNumeroFactura(numeroFactura);
        return factura != null ? ResponseEntity.ok(factura) : ResponseEntity.notFound().build();
    }
}

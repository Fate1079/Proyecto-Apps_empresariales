package com.example.appsEmpresariales.Controller;

import com.example.appsEmpresariales.Service.PagoService;
import com.example.appsEmpresariales.dto.PagoDTO;
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
@RequestMapping("/api/pagos")
@Tag(name = "pagos", description = "API para la gestión de pagos")
public class PagoController {

    private final PagoService pagoService;

    @Autowired
    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    // -------- CRUD --------
    @GetMapping
    @Operation(summary = "Obtener todos los pagos")
    @ApiResponse(responseCode = "200", description = "Pagos obtenidos con éxito")
    public ResponseEntity<List<PagoDTO>> getAllPagos() {
        return ResponseEntity.ok(pagoService.obtenerTodosLosPagos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un pago por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pago encontrado"),
            @ApiResponse(responseCode = "404", description = "Pago no encontrado")
    })
    public ResponseEntity<PagoDTO> getPagoById(
            @PathVariable @Parameter(description = "ID del pago") String id) {
        PagoDTO pago = pagoService.obtenerPagoPorId(id);
        return pago != null ? ResponseEntity.ok(pago) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo pago")
    @ApiResponse(responseCode = "201", description = "Pago creado exitosamente")
    public ResponseEntity<PagoDTO> crearPago(
            @RequestBody @Parameter(description = "Datos del pago a crear") PagoDTO pago) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagoService.guardarPago(pago));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un pago existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pago actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Pago no encontrado")
    })
    public ResponseEntity<PagoDTO> actualizarPago(
            @PathVariable String id,
            @RequestBody PagoDTO pago) {
        pago.setId(id);
        PagoDTO actualizado = pagoService.actualizarPago(pago);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un pago por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Pago eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Pago no encontrado")
    })
    public ResponseEntity<Void> eliminarPago(@PathVariable String id) {
        pagoService.eliminarPago(id);
        return ResponseEntity.noContent().build();
    }

    // -------- Búsqueda --------
    @GetMapping("/estado/{estado}")
    @Operation(summary = "Obtener pagos por estado")
    @ApiResponse(responseCode = "200", description = "Pagos obtenidos con éxito")
    public ResponseEntity<List<PagoDTO>> getPagosPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(pagoService.obtenerPagosPorEstado(estado));
    }
}

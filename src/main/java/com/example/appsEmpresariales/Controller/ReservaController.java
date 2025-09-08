package com.example.appsEmpresariales.Controller;

import com.example.appsEmpresariales.Service.ReservaService;
import com.example.appsEmpresariales.dto.ReservaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@Tag(name = "reservas", description = "API para la gestión de reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    // -------- CRUD --------
    @GetMapping
    @Operation(summary = "Obtener todas las reservas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reservas obtenidas con éxito")
    })
    public ResponseEntity<List<ReservaDTO>> getAllReservas() {
        return ResponseEntity.ok(reservaService.obtenerTodasLasReservas());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una reserva por ID")
    public ResponseEntity<ReservaDTO> getReservaById(
            @PathVariable @Parameter(description = "ID de la reserva") String id) {
        ReservaDTO reserva = reservaService.obtenerReservaPorId(id);
        return reserva != null ? ResponseEntity.ok(reserva) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Crear una nueva reserva")
    public ResponseEntity<ReservaDTO> crearReserva(
            @RequestBody @Parameter(description = "Datos de la reserva") ReservaDTO reserva) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.guardarReserva(reserva));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una reserva")
    public ResponseEntity<ReservaDTO> actualizarReserva(
            @PathVariable String id,
            @RequestBody ReservaDTO reserva) {
        reserva.setId(id);
        return ResponseEntity.ok(reservaService.actualizarReserva(reserva));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una reserva por ID")
    public ResponseEntity<Void> eliminarReserva(@PathVariable String id) {
        reservaService.eliminarReserva(id);
        return ResponseEntity.noContent().build();
    }

    // -------- Búsquedas --------
    @GetMapping("/usuario/{usuario}")
    @Operation(summary = "Obtener reservas por usuario")
    public ResponseEntity<List<ReservaDTO>> getReservasPorUsuario(@PathVariable String usuario) {
        return ResponseEntity.ok(reservaService.obtenerReservasPorUsuario(usuario));
    }

    @GetMapping("/estado/{estado}")
    @Operation(summary = "Obtener reservas por estado")
    public ResponseEntity<List<ReservaDTO>> getReservasPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(reservaService.obtenerReservasPorEstado(estado));
    }

    @GetMapping("/recurso/{recurso}")
    @Operation(summary = "Obtener reservas por recurso")
    public ResponseEntity<List<ReservaDTO>> getReservasPorRecurso(@PathVariable String recurso) {
        return ResponseEntity.ok(reservaService.obtenerReservasPorRecurso(recurso));
    }

    @GetMapping("/rango")
    @Operation(summary = "Obtener reservas en un rango de fechas")
    public ResponseEntity<List<ReservaDTO>> getReservasPorRangoFechas(
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fin) {
        return ResponseEntity.ok(reservaService.obtenerReservasPorRangoFechas(inicio, fin));
    }

    // -------- Utilitarios --------
    @GetMapping("/existe/{id}")
    @Operation(summary = "Verificar si existe una reserva por ID")
    public ResponseEntity<Boolean> existeReserva(@PathVariable String id) {
        return ResponseEntity.ok(reservaService.existeReserva(id));
    }

    @GetMapping("/count")
    @Operation(summary = "Contar todas las reservas")
    public ResponseEntity<Long> contarReservas() {
        return ResponseEntity.ok(reservaService.contarReservas());
    }

    @GetMapping("/count/estado/{estado}")
    @Operation(summary = "Contar reservas por estado")
    public ResponseEntity<Long> contarReservasPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(reservaService.contarReservasPorEstado(estado));
    }
}

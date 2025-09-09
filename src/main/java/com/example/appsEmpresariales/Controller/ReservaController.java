package com.example.appsEmpresariales.Controller;

import com.example.appsEmpresariales.Service.ReservaService;
import com.example.appsEmpresariales.dto.ReservaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Tag(name = "Reservas", description = "API para la gestión de reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    // -------- CRUD --------
    @GetMapping
    @Operation(summary = "Obtener todas las reservas", description = "Devuelve una lista de todas las reservas registradas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reservas obtenidas con éxito",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReservaDTO.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<List<ReservaDTO>> getAllReservas() {
        return ResponseEntity.ok(reservaService.obtenerTodasLasReservas());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una reserva por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reserva encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReservaDTO.class))),
            @ApiResponse(responseCode = "404", description = "Reserva no encontrada")
    })
    public ResponseEntity<ReservaDTO> getReservaById(
            @PathVariable @Parameter(description = "ID de la reserva") String id) {
        ReservaDTO reserva = reservaService.obtenerReservaPorId(id);
        return reserva != null ? ResponseEntity.ok(reserva) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Crear una nueva reserva")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Reserva creada con éxito",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReservaDTO.class)))
    })
    public ResponseEntity<ReservaDTO> crearReserva(
            @RequestBody @Parameter(description = "Datos de la reserva") ReservaDTO reserva) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.guardarReserva(reserva));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una reserva")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reserva actualizada con éxito"),
            @ApiResponse(responseCode = "404", description = "Reserva no encontrada")
    })
    public ResponseEntity<ReservaDTO> actualizarReserva(
            @PathVariable String id,
            @RequestBody ReservaDTO reserva) {
        reserva.setId(id);
        return ResponseEntity.ok(reservaService.actualizarReserva(reserva));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una reserva por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Reserva eliminada con éxito"),
            @ApiResponse(responseCode = "404", description = "Reserva no encontrada")
    })
    public ResponseEntity<Void> eliminarReserva(@PathVariable String id) {
        reservaService.eliminarReserva(id);
        return ResponseEntity.noContent().build();
    }

    // -------- Búsquedas --------
    @GetMapping("/usuario/{usuario}")
    @Operation(summary = "Obtener reservas por usuario")
    @ApiResponse(responseCode = "200", description = "Reservas encontradas")
    public ResponseEntity<List<ReservaDTO>> getReservasPorUsuario(@PathVariable String usuario) {
        return ResponseEntity.ok(reservaService.obtenerReservasPorUsuario(usuario));
    }

    @GetMapping("/estado/{estado}")
    @Operation(summary = "Obtener reservas por estado")
    @ApiResponse(responseCode = "200", description = "Reservas encontradas")
    public ResponseEntity<List<ReservaDTO>> getReservasPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(reservaService.obtenerReservasPorEstado(estado));
    }

    @GetMapping("/recurso/{recurso}")
    @Operation(summary = "Obtener reservas por recurso")
    @ApiResponse(responseCode = "200", description = "Reservas encontradas")
    public ResponseEntity<List<ReservaDTO>> getReservasPorRecurso(@PathVariable String recurso) {
        return ResponseEntity.ok(reservaService.obtenerReservasPorRecurso(recurso));
    }

    @GetMapping("/rango")
    @Operation(summary = "Obtener reservas en un rango de fechas")
    @ApiResponse(responseCode = "200", description = "Reservas encontradas en el rango especificado")
    public ResponseEntity<List<ReservaDTO>> getReservasPorRangoFechas(
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fin) {
        return ResponseEntity.ok(reservaService.obtenerReservasPorRangoFechas(inicio, fin));
    }

    // -------- Utilitarios --------
    @GetMapping("/existe/{id}")
    @Operation(summary = "Verificar si existe una reserva por ID")
    @ApiResponse(responseCode = "200", description = "Resultado de la verificación")
    public ResponseEntity<Boolean> existeReserva(@PathVariable String id) {
        return ResponseEntity.ok(reservaService.existeReserva(id));
    }

    @GetMapping("/count")
    @Operation(summary = "Contar todas las reservas")
    @ApiResponse(responseCode = "200", description = "Número total de reservas")
    public ResponseEntity<Long> contarReservas() {
        return ResponseEntity.ok(reservaService.contarReservas());
    }

    @GetMapping("/count/estado/{estado}")
    @Operation(summary = "Contar reservas por estado")
    @ApiResponse(responseCode = "200", description = "Número de reservas por estado")
    public ResponseEntity<Long> contarReservasPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(reservaService.contarReservasPorEstado(estado));
    }
}
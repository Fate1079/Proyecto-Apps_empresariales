package com.example.appsEmpresariales.Controller;

import com.example.appsEmpresariales.Service.RecursoService;
import com.example.appsEmpresariales.dto.RecursoDTO;
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
@RequestMapping("/api/recursos")
@Tag(name = "recursos", description = "API para la gestión de recursos")
public class RecursoController {

    private final RecursoService recursoService;

    @Autowired
    public RecursoController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    // -------- CRUD --------
    @GetMapping
    @Operation(summary = "Obtener todos los recursos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Recursos obtenidos con éxito")
    })
    public ResponseEntity<List<RecursoDTO>> getAllRecursos() {
        return ResponseEntity.ok(recursoService.obtenerTodosLosRecursos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un recurso por ID")
    public ResponseEntity<RecursoDTO> getRecursoById(
            @PathVariable @Parameter(description = "ID del recurso") String id) {
        RecursoDTO recurso = recursoService.obtenerRecursoPorId(id);
        return recurso != null ? ResponseEntity.ok(recurso) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo recurso")
    public ResponseEntity<RecursoDTO> crearRecurso(
            @RequestBody @Parameter(description = "Datos del recurso a crear") RecursoDTO recurso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recursoService.guardarRecurso(recurso));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un recurso")
    public ResponseEntity<RecursoDTO> actualizarRecurso(
            @PathVariable String id,
            @RequestBody RecursoDTO recurso) {
        recurso.setId(id);
        return ResponseEntity.ok(recursoService.actualizarRecurso(recurso));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un recurso por ID")
    public ResponseEntity<Void> eliminarRecurso(@PathVariable String id) {
        recursoService.eliminarRecurso(id);
        return ResponseEntity.noContent().build();
    }

    // -------- Búsquedas --------
    @GetMapping("/tipo/{tipo}")
    @Operation(summary = "Obtener recursos por tipo")
    public ResponseEntity<List<RecursoDTO>> getRecursosPorTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(recursoService.obtenerRecursosPorTipo(tipo));
    }

    @GetMapping("/estado/{estado}")
    @Operation(summary = "Obtener recursos por estado")
    public ResponseEntity<List<RecursoDTO>> getRecursosPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(recursoService.obtenerRecursosPorEstado(estado));
    }
}

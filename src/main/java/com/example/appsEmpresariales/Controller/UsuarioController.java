package com.example.appsEmpresariales.Controller;

import com.example.appsEmpresariales.Service.UsuarioService;
import com.example.appsEmpresariales.dto.UsuarioDTO;
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
@RequestMapping("/api/Usuario")
@Tag(name = "usuarios", description = "API para la gestión de usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService ){
        this.usuarioService = usuarioService;
    }


    @GetMapping
    @Operation(summary = "Obtener todas las Usuarios", description = "Devuelve una lista de todas las Usuarios registradas.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reservas obtenidas con éxito"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<List<UsuarioDTO>> getAllReservas() {
        return ResponseEntity.ok(usuarioService.obtenerTodosLosUsuarios());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una usuario por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reserva encontrada"),
            @ApiResponse(responseCode = "404", description = "Reserva no encontrada")
    })
    public ResponseEntity<UsuarioDTO> getUsuarioById(
            @PathVariable @Parameter(description = "ID de la reserva") String id) {
        UsuarioDTO reserva = usuarioService.obtenerUsuarioPorId(id);
        return reserva != null ? ResponseEntity.ok(reserva) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Guardar un usuario")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Reserva creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    public ResponseEntity<UsuarioDTO> guardarReserva(
            @RequestBody @Parameter(description = "Datos de la reserva a guardar") UsuarioDTO usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardarUsuario(usuario));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una usuario")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reserva actualizada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Reserva no encontrada")
    })
    public ResponseEntity<UsuarioDTO> actualizarReserva(
            @PathVariable @Parameter(description = "ID de la usuario") String id,
            @RequestBody @Parameter(description = "Datos de la usuario actualizados") UsuarioDTO reserva) {

        reserva.setId(id);
        UsuarioDTO actualizada = usuarioService.actualizarUsuario(reserva);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una reserva")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Reserva eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Reserva no encontrada")
    })
    public ResponseEntity<Void> eliminarReserva(
            @PathVariable @Parameter(description = "ID de la reserva") String id) {

        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/rol/{rol}")
    @Operation(summary = "Obtener usuarios por rol", description = "Devuelve una lista de usuarios que tienen el rol especificado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuarios obtenidos con éxito"),
            @ApiResponse(responseCode = "404", description = "No se encontraron usuarios con ese rol")
    })
    public ResponseEntity<List<UsuarioDTO>> getUsuariosPorRol(
            @PathVariable @Parameter(description = "Rol del usuario") String rol) {
        List<UsuarioDTO> usuarios = usuarioService.obtenerUsuariosPorRol(rol);
        return usuarios.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(usuarios);
    }

    @GetMapping("/exists/email/{email}")
    @Operation(summary = "Verificar si existe un usuario por email", description = "Devuelve true si el email está registrado, false en caso contrario.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Verificación realizada con éxito")
    })
    public ResponseEntity<Boolean> existeUsuarioPorEmail(
            @PathVariable @Parameter(description = "Email del usuario") String email) {
        boolean existe = usuarioService.existeUsuarioPorEmail(email);
        return ResponseEntity.ok(existe);
    }
}

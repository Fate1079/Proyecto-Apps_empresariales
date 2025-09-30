package com.example.appsEmpresariales.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "notificaciones")
public class NotificacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, length = 500)
    private String mensaje;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private LocalDate fechaEnvio;

    @Column(nullable = false)
    private String idUsuario;

    // -------- Constructores --------
    public NotificacionEntity() {}

    public NotificacionEntity(String id, String mensaje, String tipo, LocalDate fechaEnvio, String idUsuario) {
        this.id = id;
        this.mensaje = mensaje;
        this.tipo = tipo;
        this.fechaEnvio = fechaEnvio;
        this.idUsuario = idUsuario;
    }

    // -------- Getters & Setters --------
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public LocalDate getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDate fechaEnvio) { this.fechaEnvio = fechaEnvio; }

    public String getIdUsuario() { return idUsuario; }
    publ

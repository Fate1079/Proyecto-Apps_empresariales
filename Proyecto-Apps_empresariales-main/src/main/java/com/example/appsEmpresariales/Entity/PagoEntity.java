package com.example.appsEmpresariales.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pagos")
public class PagoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private double monto;

    @Column(nullable = false)
    private LocalDate fechaPago;

    @Column(nullable = false)
    private String metodoPago;

    @Column(nullable = false)
    private String estadoPago;

    @Column(nullable = false)
    private String idReserva;

    // -------- Constructores --------
    public PagoEntity() {}

    public PagoEntity(String id, double monto, LocalDate fechaPago, String metodoPago, String estadoPago, String idReserva) {
        this.id = id;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.estadoPago = estadoPago;
        this.idReserva = idReserva;
    }

    // -------- Getters & Setters --------
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public LocalDate getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDate fechaPago) { this.fechaPago = fechaPago; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public String getEstadoPago() { return estadoPago; }
    public void setEstadoPago(String estadoPago) { this.estadoPago = estadoPago; }

    public String getIdReserva() { return idReserva; }
    public void setIdReserva(String idReserva) { this.idReserva = idReserva; }
}

package com.DiSeven.TiendaSpring.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IdUsuario")
    private Long idUsuario;

    @Column(name = "Referencia")
    private String referencia;

    @Column(name = "Fecha")
    private LocalDateTime fecha;

    @Column(name = "Estado")
    private Estado estado;

    @Column(name = "MetodoPago")
    private MetodosPago metodoPago;

    @Column(name = "DatosPago")
    private String datosPago;

    public Pedido() {
    }

    public Pedido(Long idUsuario, String referencia, LocalDateTime fecha, Estado estado, MetodosPago metodoPago, String datosPago) {
        this.idUsuario = idUsuario;
        this.referencia = referencia;
        this.fecha = fecha;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.datosPago = datosPago;
    }

    public Long getId() {
        return id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public MetodosPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodosPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getDatosPago() {
        return datosPago;
    }

    public void setDatosPago(String datosPago) {
        this.datosPago = datosPago;
    }
}

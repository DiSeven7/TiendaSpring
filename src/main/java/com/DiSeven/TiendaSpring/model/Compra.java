package com.DiSeven.TiendaSpring.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Compras")
public class Compra {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IdUsuario")
    private Long idUsuario;

    @Column(name = "Fecha")
    private LocalDateTime fecha;

    @Column(name = "Productos")
    private String productos;

    @Column(name = "Total")
    private double total;

    @Column(name = "Estado")
    private Estado estado;

    @Column(name="MetodoPago")
    private MetodosPago metodoPago;

    @Column(name = "DatosPago")
    private String datosPago;

    public Compra(){

    }

    public Compra(Long idUsuario, LocalDateTime fecha, String productos, double total, Estado estado, MetodosPago metodoPago,
                  String datosPago) {
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.productos = productos;
        this.total = total;
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

package com.DiSeven.TiendaSpring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Ventas")
public class Venta {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IdUsuario")
    private Long idUsuario;

    @Column(name = "Referencia")
    private String referencia;

    @Column(name = "IdProducto")
    private Long idProducto;

    @Column(name = "Cantidad")
    private int cantidad;

    @Column(name = "Subtotal")
    private double subtotal;

    public Venta() {

    }

    public Venta(Long idUsuario, String referencia, Long idProducto, int cantidad, double subtotal) {
        this.idUsuario = idUsuario;
        this.referencia = referencia;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
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

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}

package com.DiSeven.TiendaSpring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Compras")
public class Compra {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "IdUsuario")
    private int idUsuario;

    @Column(name = "Fecha")
    private Date fecha;

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

    public Compra(int id, int idUsuario, Date fecha, String productos, double total, Estado estado, MetodosPago metodoPago,
                  String datosPago) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.productos = productos;
        this.total = total;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.datosPago = datosPago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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

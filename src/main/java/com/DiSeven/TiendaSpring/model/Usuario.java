package com.DiSeven.TiendaSpring.model;

import jakarta.persistence.*;
import org.w3c.dom.Text;

import java.util.Base64;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Email")
    private String email;

    @Column(name = "Contraseña")
    private String contraseña;

    @Column(name = "verificado")
    private boolean verificado;

    @Column(name = "esAdmin")
    private boolean esAdmin = false;

    public Usuario() {
    }

    public Usuario(String email, String contraseña, boolean verificado, boolean esAdmin) {
        this.email = email;
        this.contraseña = contraseña;
        this.verificado = verificado;
        this.esAdmin = esAdmin;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = Base64.getEncoder().encodeToString(contraseña.getBytes());
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }
}

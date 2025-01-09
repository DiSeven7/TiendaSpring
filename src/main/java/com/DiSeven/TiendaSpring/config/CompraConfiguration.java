package com.DiSeven.TiendaSpring.config;

import com.DiSeven.TiendaSpring.model.*;
import com.DiSeven.TiendaSpring.repository.CompraRepository;
import com.DiSeven.TiendaSpring.repository.ProductoRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

@Configuration
public class CompraConfiguration {

    private final CompraRepository compraRepository;
    public CompraConfiguration(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Bean
    boolean SeedCompras() {
        if (compraRepository.count() == 0) {
            ArrayList<Compra> compras = new ArrayList<>();
            compras.add(new Compra(1L, LocalDateTime.now(), "prueba", 12.11,
                    Estado.Procesando, MetodosPago.Tarjeta, "93938920193"));
            compras.add(new Compra(1L, LocalDateTime.now(), "prueba", 4.44,
                    Estado.Enviado, MetodosPago.PayPal, "7davidalonso7@gmail.com"));
            compras.add(new Compra(1L, LocalDateTime.now(), "prueba", 5.55, Estado.Procesando,
                    MetodosPago.Bizum, "666777888"));
            compraRepository.saveAll(compras);
            return true;
        } else {
            return false;
        }
    }

}

package com.DiSeven.TiendaSpring.config;

import com.DiSeven.TiendaSpring.model.*;
import com.DiSeven.TiendaSpring.repository.VentaRepository;
import com.DiSeven.TiendaSpring.service.VentaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class VentaConfiguration {

    private final VentaRepository ventaRepository;
    private final VentaService ventaService;

    public VentaConfiguration(VentaRepository ventaRepository, VentaService ventaService) {
        this.ventaRepository = ventaRepository;
        this.ventaService = ventaService;
    }

    @Bean
    boolean SeedCompras() {
        if (ventaRepository.count() == 0) {
            String referencia = ventaService.GenerarReferencia();
            ArrayList<Venta> ventas = new ArrayList<>();
            ventas.add(new Venta(1L, referencia, 1L, 5, 16.28));
            ventas.add(new Venta(1L, referencia, 2L, 2, 5.86));
            ventas.add(new Venta(1L, referencia, 3L, 1, 3.33));
            ventaRepository.saveAll(ventas);
            return true;
        } else {
            return false;
        }
    }

}

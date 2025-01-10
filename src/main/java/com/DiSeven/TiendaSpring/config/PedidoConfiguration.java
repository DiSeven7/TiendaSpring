package com.DiSeven.TiendaSpring.config;

import com.DiSeven.TiendaSpring.model.Estado;
import com.DiSeven.TiendaSpring.model.MetodosPago;
import com.DiSeven.TiendaSpring.model.Pedido;
import com.DiSeven.TiendaSpring.repository.PedidoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class PedidoConfiguration {

    private PedidoRepository pedidoRepository;

    public PedidoConfiguration(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Bean
    public boolean SeedPedidos() {
        if (pedidoRepository.count() == 0) {
            pedidoRepository.save(new Pedido(1L, "RFX202510011239", LocalDateTime.now(), Estado.Procesando, MetodosPago.Bizum, "676676676"));
            return true;
        } else {
            return false;
        }
    }

}

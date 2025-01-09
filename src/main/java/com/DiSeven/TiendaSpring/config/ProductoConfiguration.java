package com.DiSeven.TiendaSpring.config;

import com.DiSeven.TiendaSpring.model.Categoria;
import com.DiSeven.TiendaSpring.model.Producto;
import com.DiSeven.TiendaSpring.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class ProductoConfiguration {

    private final ProductoRepository productoRepository;

    public ProductoConfiguration(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Bean
    boolean SeedProductos() {
        if (productoRepository.count() == 0) {
            ArrayList<Producto> productos = new ArrayList<>();
            productos.add(new Producto("Coca Cola 330ml", "El clásico refresco Coca-Cola de 330ml",
                    0.85, 200, Categoria.Refrescos, "imagenes/cocacola", true));
            productos.add(new Producto("Ositos de oro", "¡Los deliciosos ositos de oro de Haribo!",
                    1.60, 25, Categoria.Dulces, "imagenes/ositosoro", true));
            productos.add(new Producto("Lays campesinas", "Patatas fritas de Lays, con sabor a tomate y cebolla",
                    1.85, 300, Categoria.Snacks, "imagenes/layscampesinas", true));
            productoRepository.saveAll(productos);
            return true;
        }
        else{
            return false;
        }
    }

}

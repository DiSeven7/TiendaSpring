package com.DiSeven.TiendaSpring.config;

import com.DiSeven.TiendaSpring.model.Usuario;
import com.DiSeven.TiendaSpring.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfiguration {

    private final UsuarioRepository usuarioRepository;

    public UsuarioConfiguration(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Bean
    boolean SeedUsuarios() {
        if (usuarioRepository.count() == 0) {
            Usuario admin = new Usuario();
            admin.setEmail("7davidalonso7@gmail.com");
            admin.setContraseña("admin");
            admin.setVerificado(true);
            admin.setEsAdmin(true);
            usuarioRepository.save(admin);
            return true;
        }
        else{
            return false;
        }
    }
}

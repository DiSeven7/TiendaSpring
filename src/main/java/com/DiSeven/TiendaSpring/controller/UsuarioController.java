package com.DiSeven.TiendaSpring.controller;

import com.DiSeven.TiendaSpring.model.Usuario;
import com.DiSeven.TiendaSpring.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/postUsuario")
    public ResponseEntity<String> postUsuario(@RequestBody  Usuario usuario) {
        usuarioRepository.save(usuario);
        return new ResponseEntity<>("Usuario creado", HttpStatus.OK);
    }

    @GetMapping("/getUsuarios")
    public ResponseEntity<List<Usuario>> getUsuarios() {
        return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getUsuario")
    public ResponseEntity<Usuario> getUsuario(@RequestParam Long id) {
        if (usuarioRepository.existsById(id)) {
            return new ResponseEntity<>(usuarioRepository.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("El id indicado no existe", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/putUsuario")
    public ResponseEntity<String> putUsuario(@RequestBody Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getId())) {
            usuarioRepository.save(usuario);
            return new ResponseEntity<>("Usuario actualizado", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El usuario no existe", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteUsuario")
    public ResponseEntity<String> deleteUsuario(@RequestParam Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return new ResponseEntity<>("Usuario eliminado", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El id indicado no existe", HttpStatus.NOT_FOUND);
        }
    }
}

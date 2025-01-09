package com.DiSeven.TiendaSpring.controller;

import com.DiSeven.TiendaSpring.model.Producto;
import com.DiSeven.TiendaSpring.repository.ProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    private ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @PostMapping("/postProducto")
    public ResponseEntity<String> postProducto(@RequestBody Producto producto) {
        productoRepository.save(producto);
        return new ResponseEntity<>("Producto añadido", HttpStatus.OK);
    }

    @GetMapping("/getProductos")
    public ResponseEntity<List<Producto>> getProductos() {
        return new ResponseEntity<>(productoRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getProducto")
    public ResponseEntity<Producto> getProducto(@RequestParam Long id) {
        if (productoRepository.existsById(id)) {
            return new ResponseEntity<>(productoRepository.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("El id no existe", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/putProducto")
    public ResponseEntity<String> putProducto(@RequestBody Producto producto) {
        if (productoRepository.existsById(producto.getId())) {
            productoRepository.save(producto);
            return new ResponseEntity<>("Producto actualizado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El id indicado no existe", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteProducto")
    public ResponseEntity<String> deleteProducto(@RequestParam Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return new ResponseEntity<>("Producto eliminado", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El id no existe", HttpStatus.NOT_FOUND);
        }
    }

}

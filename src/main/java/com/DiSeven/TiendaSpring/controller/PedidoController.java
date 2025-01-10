package com.DiSeven.TiendaSpring.controller;

import com.DiSeven.TiendaSpring.model.Estado;
import com.DiSeven.TiendaSpring.model.MetodosPago;
import com.DiSeven.TiendaSpring.model.Pedido;
import com.DiSeven.TiendaSpring.repository.PedidoRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("Pedidos")
@Tag(name = "Pedidos", description = "Pedidos realizados")
public class PedidoController {

    private PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @PostMapping("/postPedido")
    public ResponseEntity<String> PostPedido(@RequestBody Pedido pedido) {
        if (pedido != null) {
            pedidoRepository.save(pedido);
            return new ResponseEntity<>("Pedido almacenado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error. Debe enviarse un pedido que almacenar", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getPedidos")
    public ResponseEntity<List<Pedido>> getPedidos() {
        var pedidos = pedidoRepository.findAll();
        if (!pedidos.isEmpty()) {
            return new ResponseEntity<>(pedidos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getPedidos/idusuario")
    public ResponseEntity<List<Pedido>> getPedidosUsuario(@RequestParam Long idUsuario) {
        var pedidos = pedidoRepository.findByIdUsuario(idUsuario);
        if (!pedidos.isEmpty()) {
            return new ResponseEntity<>(pedidos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getPedidos/estado")
    public ResponseEntity<List<Pedido>> getPedidosEstado(@RequestParam Estado estadoPedido) {
        var pedidos = pedidoRepository.findByEstado(estadoPedido);
        if (!pedidos.isEmpty()) {
            return new ResponseEntity<>(pedidos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getPedidos/metodoPago")
    public ResponseEntity<List<Pedido>> getPedidosMetodoPago(@RequestParam MetodosPago metodoPago) {
        var pedidos = pedidoRepository.findByMetodoPago(metodoPago);
        if (!pedidos.isEmpty()) {
            return new ResponseEntity<>(pedidos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getPedido/idPedido")
    public ResponseEntity<Pedido> getPedido(@RequestParam Long id) {
        if (pedidoRepository.existsById(id)) {
            return new ResponseEntity<>(pedidoRepository.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("El id indicado no existe", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getPedido/referencia")
    public ResponseEntity<Pedido> getPedidoReferencia(@RequestParam String referencia) {
        if (pedidoRepository.existsByReferencia(referencia)) {
            return new ResponseEntity<>(pedidoRepository.findByReferencia(referencia), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/putPedido")
    public ResponseEntity<String> putPedido(@RequestBody Pedido pedido) {
        if (pedido != null) {
            if (pedidoRepository.existsById(pedido.getId())) {
                pedidoRepository.save(pedido);
                return new ResponseEntity<>("Pedido actualizado correctamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("El id indicado no existe", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Error. Debe enviarse un pedido que actualizar", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deletePedido")
    public ResponseEntity<String> deletePedido(@RequestParam Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return new ResponseEntity<>("Pedido eliminado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El id indicado no existe", HttpStatus.NOT_FOUND);
        }
    }

}

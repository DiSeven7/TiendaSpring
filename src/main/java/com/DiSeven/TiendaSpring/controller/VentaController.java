package com.DiSeven.TiendaSpring.controller;

import com.DiSeven.TiendaSpring.model.Venta;
import com.DiSeven.TiendaSpring.repository.VentaRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("Ventas")
@Tag(name = "Ventas", description = "Ventas realizadas")
public class VentaController {

    private VentaRepository ventaRepository;

    public VentaController(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @PostMapping("/postVenta")
    public ResponseEntity<String> postVenta(@RequestBody @NotNull Venta venta) {
        if (venta != null) {
            ventaRepository.save(venta);
            return new ResponseEntity<>("Venta añadida", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error. Debe enviarse una venta que almacenar", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getVentas")
    public ResponseEntity<List<Venta>> getVentas() {
        return new ResponseEntity<>(ventaRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getVentas/usuario")
    public ResponseEntity<List<Venta>> getVentasUsuario(@RequestParam Long idUsuario) {
        var ventas = ventaRepository.findByIdUsuario(idUsuario);
        if (!ventas.isEmpty()) {
            return new ResponseEntity<>(ventas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getVentas/refencia")
    public ResponseEntity<List<Venta>> getVentasReferencia(@RequestParam String referencia) {
        var ventas = ventaRepository.findByReferencia(referencia);
        if (!ventas.isEmpty()) {
            return new ResponseEntity<>(ventas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getVentas/producto")
    public ResponseEntity<List<Venta>> getVentasProducto(@RequestParam Long idProducto) {
        var ventas = ventaRepository.findByIdProducto(idProducto);
        if (!ventas.isEmpty()) {
            return new ResponseEntity<>(ventas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getVenta")
    public ResponseEntity<Venta> getVenta(@RequestParam Long id) {
        if (ventaRepository.existsById(id)) {
            return new ResponseEntity<>(ventaRepository.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("El id indicado no existe", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getTotalVenta")
    public ResponseEntity<Double> getTotalVenta(@RequestParam String referencia) {
        var ventas = ventaRepository.findByReferencia(referencia);
        if (!ventas.isEmpty()) {
            double suma = 0.00;
            for (var venta : ventas) {
                suma = suma + venta.getSubtotal();
            }
            return new ResponseEntity<>(suma, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(0.00, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/putVenta")
    public ResponseEntity<String> putVenta(@RequestBody @NotNull Venta venta) {
        if (venta != null) {
            if (ventaRepository.existsById(venta.getId())) {
                ventaRepository.save(venta);
                return new ResponseEntity<>("Venta actualizada", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("El id de la venta no existe", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Error. Debe enviarse una venta que actualizar", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteVenta")
    public ResponseEntity<String> deleteVenta(@RequestParam Long id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
            return new ResponseEntity<>("Venta eliminada", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("La venta no existe", HttpStatus.NOT_FOUND);
        }
    }

}

package com.DiSeven.TiendaSpring.controller;

import com.DiSeven.TiendaSpring.model.Compra;
import com.DiSeven.TiendaSpring.repository.CompraRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompraController {

    private CompraRepository compraRepository;

    public CompraController(CompraRepository compraRepository){
        this.compraRepository = compraRepository;
    }

    @PostMapping("/postCompra")
    public ResponseEntity postCompra(@RequestBody Compra compra){
        compraRepository.save(compra);
        return new ResponseEntity<>("Compra añaadida",HttpStatus.OK);
    }

    @GetMapping("/getCompras")
    public ResponseEntity<List<Compra>> getCompras(){
        return new ResponseEntity<>(compraRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getCompra")
    public ResponseEntity<Compra> getCompra(@RequestParam Long id){
        if(compraRepository.existsById(id)){
            return new ResponseEntity<>(compraRepository.findById(id).get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity("El id indicado no existe",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/putCompra")
    public ResponseEntity<String> putCompra(@RequestBody Compra compra){
        if(compraRepository.existsById(compra.getId())){
            compraRepository.save(compra);
            return new ResponseEntity<>("Compra actualizada",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("El id de la compra no existe",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteCompra")
    public ResponseEntity<String> deleteCompra(@RequestParam Long id){
        if(compraRepository.existsById(id)){
            compraRepository.deleteById(id);
            return new ResponseEntity<>("Compra eliminada",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("La compra no existe",HttpStatus.NOT_FOUND);
        }
    }

}

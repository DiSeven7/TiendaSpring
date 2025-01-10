package com.DiSeven.TiendaSpring.repository;

import com.DiSeven.TiendaSpring.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta,Long> {

    List<Venta> findByIdUsuario(Long idUsuario);

    List<Venta> findByReferencia(String referencia);

    List<Venta> findByIdProducto(Long idProducto);

}

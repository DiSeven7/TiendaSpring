package com.DiSeven.TiendaSpring.repository;

import com.DiSeven.TiendaSpring.model.Estado;
import com.DiSeven.TiendaSpring.model.MetodosPago;
import com.DiSeven.TiendaSpring.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    boolean existsByReferencia(String referencia);

    Pedido findByReferencia(String referencia);

    List<Pedido> findByIdUsuario(Long idUsuario);

    List<Pedido> findByEstado(Estado estadoPedido);

    List<Pedido> findByMetodoPago(MetodosPago metodoPago);

}

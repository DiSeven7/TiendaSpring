package com.DiSeven.TiendaSpring.repository;

import com.DiSeven.TiendaSpring.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra,Long> {
}
